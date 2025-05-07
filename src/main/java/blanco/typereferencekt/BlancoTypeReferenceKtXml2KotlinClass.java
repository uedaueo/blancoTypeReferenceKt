/*
 * blanco Framework
 * Copyright (C) 2004-2010 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.typereferencekt;

import blanco.cg.BlancoCgObjectFactory;
import blanco.cg.BlancoCgSupportedLang;
import blanco.cg.transformer.BlancoCgTransformerFactory;
import blanco.cg.util.BlancoCgSourceUtil;
import blanco.cg.valueobject.*;
import blanco.commons.util.BlancoNameAdjuster;
import blanco.commons.util.BlancoNameUtil;
import blanco.commons.util.BlancoStringUtil;
import blanco.typereferencekt.valueobject.BlancoTypeReferenceKtClassStructure;
import blanco.valueobjectkt.BlancoValueObjectKtXmlParser;
import blanco.valueobjectkt.message.BlancoValueObjectKtMessage;
import blanco.valueobjectkt.resourcebundle.BlancoValueObjectKtResourceBundle;
import blanco.valueobjectkt.valueobject.BlancoValueObjectKtClassStructure;
import blanco.valueobjectkt.valueobject.BlancoValueObjectKtFieldStructure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class that auto-generates Kotlin source code from intermediate XML files for value objects.
 *
 * This is one of the main classes of blancoValueObjectKt.
 *
 * @author IGA Tosiki
 * @author tueda
 */
public class BlancoTypeReferenceKtXml2KotlinClass {
    /**
     * A message.
     */
    private final BlancoValueObjectKtMessage fMsg = new BlancoValueObjectKtMessage();

    /**
     * Resource bundle object for blancoValueObject.
     */
    private final BlancoValueObjectKtResourceBundle fBundle = new BlancoValueObjectKtResourceBundle();

    /**
     * A programming language expected for the input sheet.
     */
    private int fSheetLang = BlancoCgSupportedLang.JAVA;

    public void setSheetLang(final int argSheetLang) {
        fSheetLang = argSheetLang;
    }

    /**
     * Style of the source code generation destination directory
     */
    private boolean fTargetStyleAdvanced = false;
    public void setTargetStyleAdvanced(boolean argTargetStyleAdvanced) {
        this.fTargetStyleAdvanced = argTargetStyleAdvanced;
    }
    public boolean isTargetStyleAdvanced() {
        return this.fTargetStyleAdvanced;
    }

    private boolean fVerbose = false;
    public void setVerbose(boolean argVerbose) {
        this.fVerbose = argVerbose;
    }
    public boolean isVerbose() {
        return this.fVerbose;
    }

    /*
     * Settings for overriding package name.
     */
    private String fPackageSuffix = "";
    public void setPackageSuffix(String suffix) {
        this.fPackageSuffix = suffix;
    }
    public String getPackageSuffix() {
        return this.fPackageSuffix;
    }
    private String fOverridePackage = "";
    public void setOverridePackage(String overridePackage) {
        this.fOverridePackage = overridePackage;
    }
    public String getOverridePackage() {
        return this.fOverridePackage;
    }

    /**
     * A factory for blancoCg to be used internally.
     */
    private BlancoCgObjectFactory fCgFactory = null;

    /**
     * Source file information for blancoCg to be used internally.
     */
    private BlancoCgSourceFile fCgSourceFile = null;

    /**
     * Class information for blancoCg to be used internally.
     */
    private BlancoCgClass fCgClass = null;

    /**
     * Character encoding of auto-generated source files.
     */
    private String fEncoding = null;

    public void setEncoding(final String argEncoding) {
        fEncoding = argEncoding;
    }

    private boolean fIsXmlRootElement = false;

    public void setXmlRootElement(final boolean isXmlRootElement) {
        fIsXmlRootElement = isXmlRootElement;
    }

    /**
     * Auto-generates Kotlin source code from an intermediate XML file representing a value object.
     *
     * @param argVoMetaXmlSourceFiles   An XML file containing meta-information about the ValueObject.
     * @param argRestMetaXmlSourceFiles
     * @param argDirectoryTarget       Source code generation destination directory.
     * @throws IOException If an I/O exception occurs.
     */
    public void process(
            final File[] argVoMetaXmlSourceFiles,
            final File[] argRestMetaXmlSourceFiles,
            final File argDirectoryTarget) throws IOException {



        // valueobject parser
        BlancoValueObjectKtXmlParser voParser = new BlancoValueObjectKtXmlParser();
        voParser.setVerbose(this.isVerbose());
        voParser.setPackageSuffix(this.fPackageSuffix);
        voParser.setOverridePackage(this.fOverridePackage);

        List<BlancoValueObjectKtClassStructure> voStructureList = new ArrayList<>();
        for (int index = 0; index < argVoMetaXmlSourceFiles.length; index++) {
            if (argVoMetaXmlSourceFiles[index].getName().endsWith(".xml") == false) {
                continue;
            }
            BlancoValueObjectKtClassStructure[] structures = voParser.parse(argVoMetaXmlSourceFiles[index]);
            if (structures != null && structures.length > 0) {
                voStructureList.addAll(new ArrayList<>(Arrays.asList(structures)));
            }
        }


        BlancoTypeReferenceKtXmlParser parser = new BlancoTypeReferenceKtXmlParser();
        parser.setVerbose(this.isVerbose());
        parser.setPackageSuffix(this.fPackageSuffix);
        parser.setOverridePackage(this.fOverridePackage);
        final List<BlancoTypeReferenceKtClassStructure> structures = parser.parse(argVoMetaXmlSourceFiles, argRestMetaXmlSourceFiles);

        /* Generate TypeReference Class */
        generateTypeReferenceClass(argDirectoryTarget);

        /* Generate TypeReference Maps */
        for (BlancoTypeReferenceKtClassStructure structure : structures) {
            generateTypeReferenceMap(structure, argDirectoryTarget);
        }

        /* Generate Class to TypeReference Map */
        generateTypeReferenceMapMap(structures, argDirectoryTarget);

    }

    private void generateTypeReferenceClass(
            final File argDirectoryTarget
    ) {
        /*
         * The output directory will be in the format specified by the targetStyle argument of the ant task.
         * For compatibility, the output directory will be blanco/main if it is not specified.
         * by tueda, 2019/08/30
         */
        String strTarget = argDirectoryTarget
                .getAbsolutePath(); // advanced
        if (!this.isTargetStyleAdvanced()) {
            strTarget += "/main"; // legacy
        }
        final File fileBlancoMain = new File(strTarget);

        /* tueda DEBUG */
        if (this.isVerbose()) {
            System.out.println("generateTypeReference argDirectoryTarget : " + argDirectoryTarget.getAbsolutePath());
        }

        // Gets an instance of the BlancoCgObjectFactory class.
        fCgFactory = BlancoCgObjectFactory.getInstance();

        // Replaces the package name if the Replace option is specified.
        // If Suffix is present, it takes precedence.
        String myPackage = BlancoTypeReferenceKtUtil.packageName;

        fCgSourceFile = fCgFactory.createSourceFile(myPackage, null);
        fCgSourceFile.setEncoding(fEncoding);

        fCgClass = fCgFactory.createClass(BlancoTypeReferenceKtUtil.typeRefereceClassName, "TypeReference Class");
        fCgSourceFile.getClassList().add(fCgClass);
        fCgClass.setAccess("data");
        fCgClass.setFinal(true);

        /* type */
        final BlancoCgField typeField = fCgFactory.createField("type",
                "Class", "base type");
        fCgClass.getConstructorArgList().add(typeField);
        typeField.getType().setGenerics("*");
        typeField.setConst(true);
        typeField.setNotnull(true);
        typeField.setAccess("public");
        typeField.setFinal(true);


        /* generics */
        final BlancoCgField genericsField = fCgFactory.createField("generics",
                "MutableList", "generics");
        fCgClass.getConstructorArgList().add(genericsField);
        genericsField.getType().setGenerics(BlancoTypeReferenceKtUtil.typeRefereceClassName);
        genericsField.setConst(true);
        genericsField.setNotnull(false);
        genericsField.setDefault("null");
        genericsField.setAccess("public");
        genericsField.setFinal(true);
        genericsField.setConst(true);

        /* isVirtual */
        final BlancoCgField isVirtualField = fCgFactory.createField("isVirtual",
                "Boolean", "isVirtual");
        fCgClass.getConstructorArgList().add(isVirtualField);
        isVirtualField.setConst(true);
        isVirtualField.setNotnull(true);
        isVirtualField.setDefault("false");
        isVirtualField.setAccess("public");
        isVirtualField.setFinal(true);
        isVirtualField.setConst(true);

        // Auto-generates the actual source code based on the collected information.
        BlancoCgTransformerFactory.getKotlinSourceTransformer().transform(
                fCgSourceFile, fileBlancoMain);
    }

    private void generateTypeReferenceMap(
            final BlancoTypeReferenceKtClassStructure argStructure,
            final File argDirectoryTarget
    ) {
        /*
         * The output directory will be in the format specified by the targetStyle argument of the ant task.
         * For compatibility, the output directory will be blanco/main if it is not specified.
         * by tueda, 2019/08/30
         */
        String strTarget = argDirectoryTarget
                .getAbsolutePath(); // advanced
        if (!this.isTargetStyleAdvanced()) {
            strTarget += "/main"; // legacy
        }
        final File fileBlancoMain = new File(strTarget);

        /* tueda DEBUG */
        if (this.isVerbose()) {
            System.out.println("generateTypeReferenceMapMap argDirectoryTarget : " + argDirectoryTarget.getAbsolutePath());
        }

        // Gets an instance of the BlancoCgObjectFactory class.
        fCgFactory = BlancoCgObjectFactory.getInstance();

        // Replaces the package name if the Replace option is specified.
        // If Suffix is present, it takes precedence.
        String myPackage = argStructure.getPackage();
        if (argStructure.getPackageSuffix() != null && argStructure.getPackageSuffix().length() > 0) {
            myPackage = myPackage + "." + argStructure.getPackageSuffix();
        } else if (argStructure.getOverridePackage() != null && argStructure.getOverridePackage().length() > 0) {
            myPackage = argStructure.getOverridePackage();
        }

        fCgSourceFile = fCgFactory.createSourceFile(myPackage, null);
        fCgSourceFile.setEncoding(fEncoding);

        fCgClass = fCgFactory.createClass(argStructure.getName() + BlancoTypeReferenceKtUtil.mapClassSuffix, "");
        fCgSourceFile.getClassList().add(fCgClass);

        fCgClass.setObjectClassDeclare(true);

        /* Desctiption */
        fCgClass.setDescription(argStructure.getDescription());

        /* Make virtualParams list */
        List<String> virtualParamsList = makeVirtualParamsList(argStructure.getVirtualParams());

        /* Sets the import for the class. */
        for (int index = 0; index < argStructure.getImportList()
                .size(); index++) {
            final String imported = (String) argStructure.getImportList()
                    .get(index);
            fCgSourceFile.getImportList().add(imported);
        }

        /* Make typeReference field */
        final BlancoCgField field = fCgFactory.createField(BlancoTypeReferenceKtUtil.typeReferenceMethod,
"Map<String, " + BlancoTypeReferenceKtUtil.typeRefereceClassName + ">", null);
        field.setAccess("public");
        field.setFinal(true);
        field.setOverride(false);
        field.setConst(true);
        field.setNotnull(true);
        fCgClass.getFieldList().add(field);

        StringBuffer defaultValue = new StringBuffer();
        defaultValue.append("mapOf(\n");

        for (int indexField = 0; indexField < argStructure.getFieldList()
                .size(); indexField++) {
            BlancoValueObjectKtFieldStructure fieldStructure = argStructure.getFieldList().get(indexField);
            // If a required field is not set, exception processing will be performed.
            if (fieldStructure.getName() == null) {
                throw new IllegalArgumentException(fMsg
                        .getMbvoji03(argStructure.getName()));
            }
            if (fieldStructure.getType() == null) {
                throw new IllegalArgumentException(fMsg.getMbvoji04(
                        argStructure.getName(), fieldStructure.getName()));
            }
            if (indexField > 0) {
                defaultValue.append(",\n");
            }
            // generate map
            String reference = buildMap(argStructure, fieldStructure, virtualParamsList);
            defaultValue.append(reference);
        }
        defaultValue.append(")");
        field.setDefault(defaultValue.toString());

        // import TypeReference class.
        fCgSourceFile.getImportList().add(
                BlancoTypeReferenceKtUtil.packageName + "." + BlancoTypeReferenceKtUtil.typeRefereceClassName
        );

        // Auto-generates the actual source code based on the collected information.
        BlancoCgTransformerFactory.getKotlinSourceTransformer().transform(
                fCgSourceFile, fileBlancoMain);
    }

    /**
     * Make virtualParamsList by comma separated virtualParams.
     * @param virtualParams
     * @return
     */
    private List<String> makeVirtualParamsList(String virtualParams) {
        List<String> virtualParamsList = new ArrayList<>();
        if (virtualParams != null) {
            String[] paramsArray = virtualParams.split(",");
            for (String param : paramsArray) {
                virtualParamsList.add(param.trim());
            }
        }
        return virtualParamsList;
    }

    private String buildMap(
            BlancoTypeReferenceKtClassStructure argClassStructure,
            BlancoValueObjectKtFieldStructure argFieldStructure,
            List<String> virtualParamsList
    ) {
        StringBuffer line = new StringBuffer();

        switch (fSheetLang) {
            case BlancoCgSupportedLang.PHP:
                if (argFieldStructure.getType() == "kotlin.Int") {
                    argFieldStructure.setType("kotlin.Long");
                }
                break;
            /* If you want to add more languages, add the case here. */
        }

        /* Determines the type; if typeKt is set, it will take precedence. */
        boolean isKtPreferred = true;
        String typeRaw = argFieldStructure.getTypeKt();
        if (typeRaw == null || typeRaw.length() == 0) {
            typeRaw = argFieldStructure.getType();
            isKtPreferred = false;
        }

        Boolean isVirtual = false;
        if (virtualParamsList.contains(typeRaw)) {
            typeRaw = "Any";
            isVirtual = true;
        }

        String name = argFieldStructure.getName().trim();
        String alias = argFieldStructure.getAlias();
        if (alias != null && !alias.isEmpty()) {
            name = alias.trim();
        }
        line.append("\"").append(name).append("\" to ").append(BlancoTypeReferenceKtUtil.typeRefereceClassName).append("(type = ").append(typeRaw).append("::class.java");

        BlancoCgField tmpField = fCgFactory.createField("tmpField", typeRaw, "");
        String generics = argFieldStructure.getGenericKt();
        if (BlancoStringUtil.null2Blank(generics).isEmpty()) {
            generics = argFieldStructure.getGeneric();
        }
        tmpField.getType().setGenerics(generics);
        BlancoCgType tmpType = BlancoCgSourceUtil.parseTypeWithGenerics(tmpField.getType());
        List<BlancoCgType> genericsTree = tmpType.getGenericsTree();
        if (!genericsTree.isEmpty()) {
            String nextGenerics = buildGenerics(genericsTree, virtualParamsList);
            line.append(", generics = ").append(nextGenerics);
        }

        if (isVirtual) {
            line.append(", isVirtual = true");
        }

        line.append(")");
        return line.toString();
    }

    private String buildGenerics(List<BlancoCgType> argTypeWithGenerics, List<String> virtualParamList) {
        StringBuffer line = new StringBuffer();
        line.append("mutableListOf(\n");

        int count = 0;
        for (BlancoCgType type : argTypeWithGenerics) {
            String myType = type.getName();
            Boolean isVirtual = false;
            if (virtualParamList.contains(myType)) {
                myType = "Any";
                isVirtual = true;
            }

            if (count > 0) {
                line.append(",\n");
            }
            count++;

            line.append(BlancoTypeReferenceKtUtil.typeRefereceClassName).append("(type = ").append(myType).append("::class.java");
            List<BlancoCgType> nextGenericsTree = type.getGenericsTree();

            if (!nextGenericsTree.isEmpty()) {
                String nextGenerics = buildGenerics(nextGenericsTree, virtualParamList);
                line.append(", generics = ").append(nextGenerics);
            }

            if (isVirtual) {
                line.append(", isVirtual = true");
            }
            line.append(")");
        }

        if (count > 0) {
            line.append("\n");
        }
        line.append(")");
        return line.toString();
    }

    private void generateTypeReferenceMapMap(
            final List<BlancoTypeReferenceKtClassStructure> argStructureList,
            final File argDirectoryTarget
    ) {
        /*
         * The output directory will be in the format specified by the targetStyle argument of the ant task.
         * For compatibility, the output directory will be blanco/main if it is not specified.
         * by tueda, 2019/08/30
         */
        String strTarget = argDirectoryTarget
                .getAbsolutePath(); // advanced
        if (!this.isTargetStyleAdvanced()) {
            strTarget += "/main"; // legacy
        }
        final File fileBlancoMain = new File(strTarget);

        /* tueda DEBUG */
        if (this.isVerbose()) {
            System.out.println("generateTypeReferenceMapMap argDirectoryTarget : " + argDirectoryTarget.getAbsolutePath());
        }

        // Gets an instance of the BlancoCgObjectFactory class.
        fCgFactory = BlancoCgObjectFactory.getInstance();

        // Replaces the package name if the Replace option is specified.
        // If Suffix is present, it takes precedence.
        String myPackage = BlancoTypeReferenceKtUtil.packageName;

        fCgSourceFile = fCgFactory.createSourceFile(myPackage, null);
        fCgSourceFile.setEncoding(fEncoding);

        String mapClassName = BlancoTypeReferenceKtUtil.typeRefereceClassName + BlancoTypeReferenceKtUtil.typeReferenceMapSuffix;
        fCgClass = fCgFactory.createClass(mapClassName, "TypeReference Map Class");
        fCgSourceFile.getClassList().add(fCgClass);
        fCgClass.setNoClassDeclare(true);

        String propName = BlancoNameAdjuster.toParameterName(mapClassName);

        final BlancoCgField mapField = fCgFactory.createField(propName,
                "Map", "TypeReference Map");
        fCgClass.getFieldList().add(mapField);

        String strMapValue = "Map<String, " + BlancoTypeReferenceKtUtil.typeRefereceClassName + ">";
        String strMapKey = "Class<*>";
        Boolean isKeyTypeClass = true;
        if (BlancoTypeReferenceKtUtil.mapKeyType.equalsIgnoreCase("string")) {
            strMapKey = "String";
            isKeyTypeClass = false;
        }
        mapField.getType().setGenerics(strMapKey + ", " + strMapValue);
        mapField.setConst(true);
        mapField.setNotnull(true);
        mapField.setAccess("public");
        mapField.setFinal(true);

        StringBuffer defaultValue = new StringBuffer();
        defaultValue.append("mapOf(\n");

        int count = 0;
        for (BlancoTypeReferenceKtClassStructure structure : argStructureList) {
            String line = generateKeyValueOfClassToMap(structure, isKeyTypeClass);
            if (count > 0) {
                defaultValue.append(",\n");
            }
            count++;
            defaultValue.append(line);
        }
        if (count > 0) {
            defaultValue.append("\n");
        }
        defaultValue.append(")");

        mapField.setDefault(defaultValue.toString());

        // Auto-generates the actual source code based on the collected information.
        BlancoCgTransformerFactory.getKotlinSourceTransformer().transform(
                fCgSourceFile, fileBlancoMain);
    }

    private String generateKeyValueOfClassToMap(
            final BlancoTypeReferenceKtClassStructure argStructure,
            final Boolean argIsKeyTypeClass
    ) {
        // Replaces the package name if the Replace option is specified.
        // If Suffix is present, it takes precedence.
        String myPackage = argStructure.getPackage();
        if (argStructure.getPackageSuffix() != null && argStructure.getPackageSuffix().length() > 0) {
            myPackage = myPackage + "." + argStructure.getPackageSuffix();
        } else if (argStructure.getOverridePackage() != null && argStructure.getOverridePackage().length() > 0) {
            myPackage = argStructure.getOverridePackage();
        }

        String className = argStructure.getName();
        String fullClassName = myPackage + "." + className;
        String mapClassName = className + BlancoTypeReferenceKtUtil.mapClassSuffix;
        String fullMapClassName = myPackage + "." + mapClassName;

        String key = className;
        String value = mapClassName + "." + BlancoTypeReferenceKtUtil.typeReferenceMethod;
        fCgSourceFile.getImportList().add(fullMapClassName);
        if (argIsKeyTypeClass) {
            key = mapClassName + "::class.java";
            fCgSourceFile.getImportList().add(fullClassName);
        }

        StringBuffer line = new StringBuffer();
        line.append(key + " to " + value);
        return line.toString();
    }
}

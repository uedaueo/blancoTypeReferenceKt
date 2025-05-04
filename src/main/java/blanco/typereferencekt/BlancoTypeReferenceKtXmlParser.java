/*
 * blanco Framework
 * Copyright (C) 2004-2008 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.typereferencekt;

import blanco.cg.BlancoCgSupportedLang;
import blanco.commons.util.BlancoNameUtil;
import blanco.commons.util.BlancoStringUtil;
import blanco.restgeneratorkt.BlancoRestGeneratorKtXmlParser;
import blanco.restgeneratorkt.valueobject.BlancoRestGeneratorKtTelegramFieldStructure;
import blanco.restgeneratorkt.valueobject.BlancoRestGeneratorKtTelegramProcessStructure;
import blanco.restgeneratorkt.valueobject.BlancoRestGeneratorKtTelegramStructure;
import blanco.typereferencekt.valueobject.BlancoTypeReferenceKtClassStructure;
import blanco.valueobjectkt.BlancoValueObjectKtXmlParser;
import blanco.valueobjectkt.message.BlancoValueObjectKtMessage;
import blanco.valueobjectkt.valueobject.BlancoValueObjectKtClassStructure;
import blanco.valueobjectkt.valueobject.BlancoValueObjectKtDelegateStructure;
import blanco.valueobjectkt.valueobject.BlancoValueObjectKtExtendsStructure;
import blanco.valueobjectkt.valueobject.BlancoValueObjectKtFieldStructure;
import blanco.xml.bind.BlancoXmlBindingUtil;
import blanco.xml.bind.BlancoXmlUnmarshaller;
import blanco.xml.bind.valueobject.BlancoXmlAttribute;
import blanco.xml.bind.valueobject.BlancoXmlDocument;
import blanco.xml.bind.valueobject.BlancoXmlElement;

import java.io.File;
import java.util.*;

/**
 * A class that parses (reads and writes) the intermediate XML file format of a blancoValueObject.
 *
 * @author IGA Tosiki
 */
public class BlancoTypeReferenceKtXmlParser {
    /**
     * A message.
     */
    private final BlancoValueObjectKtMessage fMsg = new BlancoValueObjectKtMessage();

    private boolean fVerbose = false;
    public void setVerbose(boolean argVerbose) {
        this.fVerbose = argVerbose;
    }
    public boolean isVerbose() {
        return fVerbose;
    }

    /*
     * Settings for overriding package names.
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
     * Parses an XML document in an intermediate XML file to get an array of value object information.
     *
     * @param argVoMetaXmlSourceFiles
     *            An intermediate XML file.
     * @param argRestMetaXmlSourceFiles
     *            An intermediate XML file.
     * @return An array of information obtained as a result of parsing.
     */
    public List<BlancoTypeReferenceKtClassStructure> parse(
            final File[] argVoMetaXmlSourceFiles,
            final File[] argRestMetaXmlSourceFiles
    ) {
        List<BlancoTypeReferenceKtClassStructure> structureList = new ArrayList<>();

        // valueobject parser
        BlancoValueObjectKtXmlParser voParser = new BlancoValueObjectKtXmlParser();
        voParser.setVerbose(this.isVerbose());
        voParser.setPackageSuffix(this.fPackageSuffix);
        voParser.setOverridePackage(this.fOverridePackage);

        for (int index = 0; index < argVoMetaXmlSourceFiles.length; index++) {
            if (argVoMetaXmlSourceFiles[index].getName().endsWith(".xml") == false) {
                continue;
            }
            BlancoValueObjectKtClassStructure[] structures = voParser.parse(argVoMetaXmlSourceFiles[index]);
            structureList.addAll(this.parseVoStructures(structures));
        }

        // restgenerator parser
        BlancoRestGeneratorKtXmlParser restParser = new BlancoRestGeneratorKtXmlParser();
        restParser.setVerbose(this.isVerbose());
        restParser.setCreateServiceMethod(false);
        restParser.setServerType("micronaut");
        restParser.setTelegramPackage("blanco.restgenerator.valueobject");

        for (int index = 0; index < argRestMetaXmlSourceFiles.length; index++) {
            if (argRestMetaXmlSourceFiles[index].getName().endsWith(".xml") == false) {
                continue;
            }
            BlancoRestGeneratorKtTelegramProcessStructure[] structures =
                    restParser.parse(argRestMetaXmlSourceFiles[index]);
            structureList.addAll(parseRestStructures(structures));
        }

        return structureList;
    }

    private List<BlancoTypeReferenceKtClassStructure> parseVoStructures(
            BlancoValueObjectKtClassStructure[] voStructures
    ) {
        List<BlancoTypeReferenceKtClassStructure> structureList = new ArrayList<>();

        for (int index = 0; index < voStructures.length; index++) {
            BlancoValueObjectKtClassStructure tmpStructure = voStructures[index];
            BlancoTypeReferenceKtClassStructure structure = new BlancoTypeReferenceKtClassStructure();

            structure.setName(tmpStructure.getName());
            structure.setPackage(tmpStructure.getPackage());
            structure.setGeneric(tmpStructure.getGeneric());
            structure.setVirtualParams(tmpStructure.getVirtualParams());
            structure.setVirtualParams(tmpStructure.getVirtualParams());
            structure.setAnnotationList(tmpStructure.getAnnotationList());
            structure.setDescription(tmpStructure.getDescription());
            structure.setAccess(tmpStructure.getAccess());
            structure.setData(tmpStructure.getData());
            structure.setAbstract(tmpStructure.getAbstract());
            structure.setFinal(tmpStructure.getFinal());
            structure.setGenerateToString(tmpStructure.getGenerateToString());
            structure.setAdjustFieldName(tmpStructure.getAdjustFieldName());
            structure.setAdjustDefaultValue(tmpStructure.getAdjustDefaultValue());

            structure.setExtends(tmpStructure.getExtends());
            structure.setImplementsList(tmpStructure.getImplementsList());
            structure.setImportList(tmpStructure.getImportList());

            structure.setFieldList(tmpStructure.getFieldList());

            structureList.add(structure);
        }

        return structureList;
    }

    private List<BlancoTypeReferenceKtClassStructure> parseRestStructures(
            BlancoRestGeneratorKtTelegramProcessStructure[] restStructures
    ) {
        List<BlancoTypeReferenceKtClassStructure> structureList = new ArrayList<>();
        for (int index = 0; index < restStructures.length; index++) {
            BlancoRestGeneratorKtTelegramProcessStructure tmpProcessStructure = restStructures[index];

            Map<String, HashMap<String, BlancoRestGeneratorKtTelegramStructure>> mapTelegrams = tmpProcessStructure.getListTelegrams();

            Set<String> methodKeys = mapTelegrams.keySet();

            for (String method : methodKeys) {
                HashMap<String, BlancoRestGeneratorKtTelegramStructure> telegramMap = mapTelegrams.get(method);
               Set<String> telegramKeys = telegramMap.keySet();
               for (String key : telegramKeys) {
                   BlancoRestGeneratorKtTelegramStructure tmpStructure = telegramMap.get(key);

                   BlancoTypeReferenceKtClassStructure structure = new BlancoTypeReferenceKtClassStructure();
                   structureList.add(structure);

                   structure.setName(tmpStructure.getName());
                   structure.setPackage(tmpStructure.getPackage());
                   structure.setGeneric(tmpStructure.getGeneric());
                   structure.setVirtualParams(tmpStructure.getVirtualParams());
                   structure.setAnnotationList(tmpStructure.getAnnotationList());
                   structure.setDescription(tmpStructure.getDescription());
                   structure.setAccess(tmpStructure.getAccess());
                   structure.setData(tmpStructure.getData());
//                   structure.setAbstract(tmpStructure.getAbstract());
                   structure.setFinal(tmpStructure.getFinal());
                   structure.setGenerateToString(false);
                   structure.setAdjustFieldName(tmpStructure.getAdjustFieldName());
                   structure.setAdjustDefaultValue(false);

                   if (!BlancoStringUtil.null2Blank(tmpStructure.getExtends()).trim().isEmpty()) {
                       BlancoValueObjectKtExtendsStructure extendsStructure = new BlancoValueObjectKtExtendsStructure();
                       extendsStructure.setType(tmpStructure.getExtends());
                       structure.setExtends(extendsStructure);
                   }
                   structure.setImplementsList(tmpStructure.getImplementsList());
                   structure.setImportList(tmpStructure.getImportList());

                   if (!tmpStructure.getListField().isEmpty()) {
                       ArrayList<BlancoValueObjectKtFieldStructure> voFields = new ArrayList<>();
                        for (BlancoRestGeneratorKtTelegramFieldStructure restFieldStructure : tmpStructure.getListField()) {
                            BlancoValueObjectKtFieldStructure voFieldStructure = new BlancoValueObjectKtFieldStructure();
                            voFields.add(voFieldStructure);

                            voFieldStructure.setNo(restFieldStructure.getNo());
                            voFieldStructure.setName(restFieldStructure.getName());
                            voFieldStructure.setAlias(restFieldStructure.getAlias());
                            voFieldStructure.setType(restFieldStructure.getType());
                            voFieldStructure.setGeneric(restFieldStructure.getGeneric());
                            voFieldStructure.setGenericKt(restFieldStructure.getGenericKt());
                            voFieldStructure.setDescription(restFieldStructure.getDescription());
                            voFieldStructure.setDefault(restFieldStructure.getDefault());
                        }
                       structure.setFieldList(voFields);
                   }
               }
            }
        }
        return structureList;
    }
}

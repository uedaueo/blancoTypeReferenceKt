/*
 * blanco Framework
 * Copyright (C) 2004-2008 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.typereferencekt.task;

import blanco.cg.BlancoCgSupportedLang;
import blanco.restgeneratorkt.BlancoRestGeneratorKtConstants;
import blanco.typereferencekt.*;
import blanco.typereferencekt.message.BlancoTypeReferenceKtMessage;
import blanco.typereferencekt.task.valueobject.BlancoTypeReferenceKtProcessInput;
import blanco.valueobjectkt.BlancoValueObjectKtConstants;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class BlancoTypeReferenceKtProcessImpl implements BlancoTypeReferenceKtProcess {

    /**
     * messages.
     */
    private final BlancoTypeReferenceKtMessage fMsg = new BlancoTypeReferenceKtMessage();

    /**
     * {@inheritDoc}
     */
    public int execute(final BlancoTypeReferenceKtProcessInput input)
            throws IOException, IllegalArgumentException {
        System.out.println("- " + BlancoTypeReferenceKtConstants.PRODUCT_NAME
                + " (" + BlancoTypeReferenceKtConstants.VERSION + ")");
        try {
            /*
             * Determines the newline code.
             */
            String LF = "\n";
            String CR = "\r";
            String CRLF = CR + LF;
            String lineSeparatorMark = input.getLineSeparator();
            String lineSeparator = "";
            if ("LF".equals(lineSeparatorMark)) {
                lineSeparator = LF;
            } else if ("CR".equals(lineSeparatorMark)) {
                lineSeparator = CR;
            } else if ("CRLF".equals(lineSeparatorMark)) {
                lineSeparator = CRLF;
            }
            if (lineSeparator.length() != 0) {
                System.setProperty("line.separator", lineSeparator);
                if (input.getVerbose()) {
                    System.out.println("lineSeparator try to change to " + lineSeparatorMark);
                    String newProp = System.getProperty("line.separator");
                    String newMark = "other";
                    if (LF.equals(newProp)) {
                        newMark = "LF";
                    } else if (CR.equals(newProp)) {
                        newMark = "CR";
                    } else if (CRLF.equals(newProp)) {
                        newMark = "CRLF";
                    }
                    System.out.println("New System Props = " + newMark);
                }
            }

            /*
             * Processes targetdir and targetStyle.
             * Sets the storage location for the generated code.
             * targetstyle = blanco:
             *  Creates a main directory under targetdir.
             * targetstyle = maven:
             *  Creates a main/java directory under targetdir.
             * targetstyle = free:
             *  Creates a directory using targetdir as is.
             *  However, if targetdir is empty, the default string (blanco) is used.
             * by tueda, 2019/08/30
             */
            String strTarget = input.getTargetdir();
            String style = input.getTargetStyle();
            // Always true when passing through here.
            boolean isTargetStyleAdvanced = true;
            if (style != null && BlancoTypeReferenceKtConstants.TARGET_STYLE_MAVEN.equals(style)) {
                strTarget = strTarget + "/" + BlancoTypeReferenceKtConstants.TARGET_DIR_SUFFIX_MAVEN;
            } else if (style == null ||
                    !BlancoTypeReferenceKtConstants.TARGET_STYLE_FREE.equals(style)) {
                strTarget = strTarget + "/" + BlancoTypeReferenceKtConstants.TARGET_DIR_SUFFIX_BLANCO;
            }
            /* If style is free, uses targetdir as is. */
            if (input.getVerbose()) {
                System.out.println("TARGETDIR = " + strTarget);
            }

            BlancoTypeReferenceKtUtil.packageName = input.getPackageName();
            BlancoTypeReferenceKtUtil.typeRefereceClassName = input.getClassName();

            // Creates a temporary directory.
            new File(input.getTmpdir()
                    + BlancoTypeReferenceKtConstants.TARGET_SUBDIRECTORY).mkdirs();

            // process meta of blancoValueObject
            BlancoTypeReferenceKtUtil.processMetaDirs(input.getValueObjectMetadirs(), input.getTmpdir() + BlancoValueObjectKtConstants.TARGET_SUBDIRECTORY);

            // process meta of restgenerator
            BlancoTypeReferenceKtUtil.processMetaDirs(input.getRestgeneratorMetadirs(), input.getTmpdir() + BlancoRestGeneratorKtConstants.TARGET_SUBDIRECTORY);

            // valueobjects
            final File[] voMetaList = new File(input.getTmpdir()
                    + BlancoValueObjectKtConstants.TARGET_SUBDIRECTORY)
                    .listFiles();
            // restgenerator
            final File[] restMetaList = new File(input.getTmpdir() + BlancoRestGeneratorKtConstants.TARGET_SUBDIRECTORY).listFiles();


            final BlancoTypeReferenceKtXml2KotlinClass xml2KotlinClass = new BlancoTypeReferenceKtXml2KotlinClass();
            xml2KotlinClass.setEncoding(input.getEncoding());
            xml2KotlinClass.setVerbose(input.getVerbose());
            xml2KotlinClass.setTargetStyleAdvanced(isTargetStyleAdvanced);
            xml2KotlinClass.setXmlRootElement(input.getXmlrootelement());
            xml2KotlinClass.setSheetLang(new BlancoCgSupportedLang().convertToInt(input.getSheetType()));

            xml2KotlinClass.process(voMetaList, restMetaList, new File(strTarget));

            return BlancoTypeReferenceKtBatchProcess.END_SUCCESS;
        } catch (TransformerException e) {
            throw new IOException("An exception has occurred during the XML conversion process: " + e.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean progress(final String argProgressMessage) {
        System.out.println(argProgressMessage);
        return false;
    }
}

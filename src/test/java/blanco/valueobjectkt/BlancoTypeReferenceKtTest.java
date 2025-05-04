/*
 * blanco Framework
 * Copyright (C) 2004-2020 IGA Tosiki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.valueobjectkt;

import java.io.IOException;

import blanco.typereferencekt.task.valueobject.BlancoTypeReferenceKtProcessInput;
import org.junit.jupiter.api.Test;

import blanco.typereferencekt.task.BlancoTypeReferenceKtProcessImpl;
import blanco.valueobjectkt.task.valueobject.BlancoValueObjectKtProcessInput;

/**
 * Generation test for Kotlin.
 *
 * @author IGA Tosiki
 * @author tueda
 */
public class BlancoTypeReferenceKtTest {

    @Test
    public void testBlancoTypeReferenceKt() {
        BlancoTypeReferenceKtProcessInput input = new BlancoTypeReferenceKtProcessInput();
        input.setMetadir("meta/objects");
        input.setEncoding("UTF-8");
        input.setSheetType("php");
        input.setTmpdir("tmpTest");
        input.setTargetdir("sample/blanco");
        input.setTargetStyle("maven");
        input.setVerbose(true);
        input.setLineSeparator("LF");
        input.setClassName("BlancoTypeReferenceTest");
        input.setMapKeyType("class");
        input.setValueObjectMetadirs("meta/objects");
        input.setRestgeneratorMetadirs("meta/rest");

        BlancoTypeReferenceKtProcessImpl imple = new BlancoTypeReferenceKtProcessImpl();
        try {
            imple.execute(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

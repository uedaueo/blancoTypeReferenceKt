package blanco.typereferencekt;

import blanco.cg.BlancoCgSupportedLang;
import blanco.restgeneratorkt.BlancoRestGeneratorKtMeta2Xml;
import blanco.typereferencekt.message.BlancoTypeReferenceKtMessage;
import blanco.typereferencekt.task.valueobject.BlancoTypeReferenceKtProcessInput;
import blanco.typereferencekt.valueobject.BlancoTypeReferenceKtClassStructure;
import blanco.valueobjectkt.BlancoValueObjectKtConstants;
import blanco.valueobjectkt.BlancoValueObjectKtMeta2Xml;
import blanco.valueobjectkt.resourcebundle.BlancoValueObjectKtResourceBundle;
import blanco.xml.bind.BlancoXmlBindingUtil;
import blanco.xml.bind.BlancoXmlUnmarshaller;
import blanco.xml.bind.valueobject.BlancoXmlDocument;
import blanco.xml.bind.valueobject.BlancoXmlElement;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class BlancoTypeReferenceKtUtil {

    public static boolean isVerbose = false;
    /**
     * Stores the package name with the SimpleClass name as the key.
     */
    public static Map<String, String> packageMap = new HashMap<>();

    /**
     * messages.
     */
    public final static BlancoTypeReferenceKtMessage fMsg = new BlancoTypeReferenceKtMessage();

    /**
     * Resource bundle object for blancoValueObject.
     */
    public final static BlancoValueObjectKtResourceBundle fBundle = new BlancoValueObjectKtResourceBundle();

    public static Map<String, Integer> mapCommons = new HashMap<String, Integer>() {
        {put(fBundle.getMeta2xmlElementCommon(), BlancoCgSupportedLang.JAVA);}
        {put(fBundle.getMeta2xmlElementCommonCs(), BlancoCgSupportedLang.CS);}
        {put(fBundle.getMeta2xmlElementCommonJs(), BlancoCgSupportedLang.JS);}
        {put(fBundle.getMeta2xmlElementCommonVb(), BlancoCgSupportedLang.VB);}
        {put(fBundle.getMeta2xmlElementCommonPhp(), BlancoCgSupportedLang.PHP);}
        {put(fBundle.getMeta2xmlElementCommonRuby(), BlancoCgSupportedLang.RUBY);}
        {put(fBundle.getMeta2xmlElementCommonPython(), BlancoCgSupportedLang.PYTHON);}
    };

    public static Boolean isSerdeable = false;
    public static Boolean isIgnoreUnknown = false;
    public static Boolean isNullableAnnotation = false;

    public static String voPackageSuffix = null;
    public static String voPackageOverride = null;
    public static String restPackageSuffix = null;
    public static String restPackageOverride = null;

    public static String packageName = "blanco.typereference";
    public static String typeRefereceClassName = "BlancoTypeReference";
    public static String typeReferenceMapSuffix = "Map";
    public static String mapKeyType = "class";
    public static String mapClassSuffix = "TypeReference";
    public static String typeReferenceMethod = "typeReference";

    public static void processMetaDirs(
            final String metaDirs,
            final String tmpDir
    ) throws IOException, TransformerException {
        String[] metaDirArray = metaDirs.split(",");
        for (String metaDir : metaDirArray) {
            final File fileMetadir = new File(metaDir.trim());
            if (!fileMetadir.exists()) {
                throw new IllegalArgumentException(fMsg.getMbvoja01(metaDir));
            }
            if (tmpDir.endsWith(BlancoValueObjectKtConstants.TARGET_SUBDIRECTORY)) {
                new BlancoValueObjectKtMeta2Xml().processDirectory(fileMetadir,  tmpDir);
            } else {
                new BlancoRestGeneratorKtMeta2Xml().processDirectory(fileMetadir,  tmpDir);
            }
        }
    }

    public static String searchImport(final String argTypeName, List<BlancoTypeReferenceKtClassStructure> argStructureList) {
        String importStr = null;

        for (BlancoTypeReferenceKtClassStructure structure : argStructureList) {
            if (argTypeName != null && argTypeName.trim().equals(structure.getName().trim())) {
                importStr = structure.getPackage().trim() + "." + structure.getName().trim();
            }
        }
        return importStr;
    }

//    public static Map<String, String> processValueObjects(final BlancoTypeReferenceKtProcessInput input) {
//        if (isVerbose) {
//            System.out.println("BlancoTypeReferenceKtUtil : processValueObjects start !");
//        }
//
//        /* tmpdir is unique. */
//        String baseTmpdir = input.getTmpdir();
//        /* searchTmpdir is comma separated. */
//        String tmpTmpdirs = input.getSearchTmpdir();
//        List<String> searchTmpdirList = null;
//        if (tmpTmpdirs != null && !tmpTmpdirs.equals(baseTmpdir)) {
//            String[] searchTmpdirs = tmpTmpdirs.split(",");
//            searchTmpdirList = new ArrayList<>(Arrays.asList(searchTmpdirs));
//        }
//        if (searchTmpdirList == null) {
//            searchTmpdirList = new ArrayList<>();
//        }
//        searchTmpdirList.add(baseTmpdir);
//
//        for (String tmpdir : searchTmpdirList) {
//            // Reads information from XML-ized intermediate files.
//            final File[] fileMeta = new File(tmpdir
//                    + BlancoTypeReferenceKtConstants.TARGET_SUBDIRECTORY)
//                    .listFiles();
//            searchTmpdir(fileMeta, input.getPackageSuffix(), input.getOverridePackage());
//        }
//
//        return packageMap;
//    }

    public static Map<String, String> searchTmpdir(final File[] argFileMeta, String packageSuffix, String overridePackage) {
        Map<String, String> classList = new HashMap<>();

        for (int index = 0; index < argFileMeta.length; index++) {
            File metaXmlSourceFile = argFileMeta[index];

            if (metaXmlSourceFile.getName().endsWith(".xml") == false) {
                continue;
            }

            final BlancoXmlDocument documentMeta = new BlancoXmlUnmarshaller()
                    .unmarshal(metaXmlSourceFile);
            if (documentMeta == null) {
                continue;
            }

            // Gets the root element.
            final BlancoXmlElement elementRoot = BlancoXmlBindingUtil
                    .getDocumentElement(documentMeta);
            if (elementRoot == null) {
                // If there is no root element, aborts the process.
                continue;
            }

            // Gets a list of sheets (Excel sheets).
            final List<BlancoXmlElement> listSheet = BlancoXmlBindingUtil
                    .getElementsByTagName(elementRoot, "sheet");

            for (BlancoXmlElement elementSheet : listSheet) {
                /*
                 * Supports sheets written for languages other than Java.
                 */
                List<BlancoXmlElement> listCommon = null;
                for (String common : mapCommons.keySet()) {
                    listCommon = BlancoXmlBindingUtil
                            .getElementsByTagName(elementSheet,
                                    common);
                    if (listCommon.size() != 0) {
                        BlancoXmlElement elementCommon = listCommon.get(0);

                        // Replaces the package name if the Replace option is specified.
                        // If there is a Suffix, it will take precedence.
                        String myPackage = BlancoXmlBindingUtil.getTextContent(elementCommon, "package");

                        if (packageSuffix != null && packageSuffix.length() > 0) {
                            myPackage = myPackage + "." + packageSuffix;
                        } else if (overridePackage != null && overridePackage.length() > 0) {
                            myPackage = overridePackage;
                        }

                        classList.put(
                                BlancoXmlBindingUtil.getTextContent(elementCommon, "name"),
                                myPackage
                        );

//                        System.out.println("/* tueda */ createClassList = " +
//                                BlancoXmlBindingUtil.getTextContent(elementCommon, "name") + " : " +
//                                BlancoXmlBindingUtil.getTextContent(elementCommon, "package"));
                        break;
                    }
                }
            }
        }

        packageMap.putAll(classList);
        return packageMap;
    }

    /**
     * Make canonical classname into Simple.
     *
     * @param argClassNameCanon
     * @return simpleName
     */
    static public String getSimpleClassName(final String argClassNameCanon) {
        if (argClassNameCanon == null) {
            return "";
        }

        String simpleName = "";
        final int findLastDot = argClassNameCanon.lastIndexOf('.');
        if (findLastDot == -1) {
            simpleName = argClassNameCanon;
        } else if (findLastDot != argClassNameCanon.length() - 1) {
            simpleName = argClassNameCanon.substring(findLastDot + 1);
        }
        return simpleName;
    }

    /**
     * Make canonical classname into packageName
     *
     * @param argClassNameCanon
     * @return
     */
    static public String getPackageName(final String argClassNameCanon) {
        if (argClassNameCanon == null) {
            return "";
        }

        String simpleName = "";
        final int findLastDot = argClassNameCanon.lastIndexOf('.');
        if (findLastDot > 0) {
            simpleName = argClassNameCanon.substring(0, findLastDot);
        }
        return simpleName;
    }

    /**
     * Add new annotaion. ignore if duplicate.
     * @param argAnnotation
     * @param argFullAnnotation
     * @param argImport
     * @param argAnnotationList
     * @param argImportList
     * @return
     */
    static public boolean addNewAnnotation(
            final String argAnnotation,
            final String argFullAnnotation,
            final String argImport,
            final List<String> argAnnotationList,
            final List<String> argImportList) {
        /* Check already added */
        boolean found = false;
        for (String ann : argAnnotationList) {
            if (ann.contains(argAnnotation)) {
                found = true;
            }
        }
        if (found) {
            System.out.println("@" + argAnnotation + " already exists. SKIP!!");
        } else {
            argAnnotationList.add(argFullAnnotation);
            argImportList.add(argImport);
        }
        return found;
    }
}

package blanco.typereferencekt.resourcebundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * blancoTypeReferenceKtが利用するリソースバンドルを蓄えます。
 *
 * リソースバンドル定義: [BlancoTypeReferenceKt]。<BR>
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 * 既知のロケール<BR>
 * <UL>
 * <LI>ja
 * </UL>
 */
public class BlancoTypeReferenceKtResourceBundle {
    /**
     * リソースバンドルオブジェクト。
     *
     * 内部的に実際に入力を行うリソースバンドルを記憶します。
     */
    private ResourceBundle fResourceBundle;

    /**
     * BlancoTypeReferenceKtResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoTypeReferenceKt]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     */
    public BlancoTypeReferenceKtResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/typereferencekt/resourcebundle/BlancoTypeReferenceKt");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoTypeReferenceKtResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoTypeReferenceKt]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     */
    public BlancoTypeReferenceKtResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/typereferencekt/resourcebundle/BlancoTypeReferenceKt", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoTypeReferenceKtResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoTypeReferenceKt]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     * @param loader クラスローダの指定
     */
    public BlancoTypeReferenceKtResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/typereferencekt/resourcebundle/BlancoTypeReferenceKt", locale, loader);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * Gets the resource bundle object held internally.
     *
     * @return The resource bundle object held internally.
     */
    public ResourceBundle getResourceBundle() {
        return fResourceBundle;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[METAFILE_DISPLAYNAME]
     *
     * [バリューオブジェクト定義書] (ja)<br>
     *
     * @return key[METAFILE_DISPLAYNAME]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMetafileDisplayname() {
        // 初期値として定義書の値を利用します。
        String strFormat = "バリューオブジェクト定義書";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("METAFILE_DISPLAYNAME");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_COMMON]
     *
     * [blancovalueobjectkt-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommon() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectkt-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_LIST]
     *
     * [blancovalueobjectkt-list] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_LIST]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementList() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectkt-list";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_LIST");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_EXTENDS]
     *
     * [blancovalueobjectkt-extends] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_EXTENDS]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementExtends() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectkt-extends";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_EXTENDS");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_IMPLEMENTS]
     *
     * [blancovalueobjectkt-implements] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_IMPLEMENTS]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementImplements() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectkt-implements";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_IMPLEMENTS");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.FIELD.NAME]
     *
     * [フィールド: [{0}]。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.FIELD.NAME]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassFieldName(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド: [{0}]。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.FIELD.NAME");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.FIELD.DEFAULT]
     *
     * [デフォルト: [{0}]。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.FIELD.DEFAULT]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassFieldDefault(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "デフォルト: [{0}]。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.FIELD.DEFAULT");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.SET.JAVADOC.01]
     *
     * [フィールド [{0}] の値を設定します。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.SET.JAVADOC.01]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassSetJavadoc01(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド [{0}] の値を設定します。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.SET.JAVADOC.01");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.SET.JAVADOC.02]
     *
     * [フィールドの説明: [{0}]。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.SET.JAVADOC.02]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassSetJavadoc02(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールドの説明: [{0}]。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.SET.JAVADOC.02");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.SET.ARG.JAVADOC]
     *
     * [フィールド[{0}]に設定する値。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.SET.ARG.JAVADOC]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassSetArgJavadoc(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド[{0}]に設定する値。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.SET.ARG.JAVADOC");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.GET.JAVADOC.01]
     *
     * [フィールド [{0}] の値を取得します。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.GET.JAVADOC.01]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassGetJavadoc01(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド [{0}] の値を取得します。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.GET.JAVADOC.01");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.GET.JAVADOC.02]
     *
     * [フィールドの説明: [{0}]。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.GET.JAVADOC.02]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassGetJavadoc02(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールドの説明: [{0}]。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.GET.JAVADOC.02");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.GET.DEFAULT.JAVADOC]
     *
     * [デフォルト: [{0}]。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.GET.DEFAULT.JAVADOC]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassGetDefaultJavadoc(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "デフォルト: [{0}]。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.GET.DEFAULT.JAVADOC");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2JAVACLASS.GET.RETURN.JAVADOC]
     *
     * [フィールド[{0}]から取得した値。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2JAVACLASS.GET.RETURN.JAVADOC]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2javaclassGetReturnJavadoc(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド[{0}]から取得した値。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2JAVACLASS.GET.RETURN.JAVADOC");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.ERR001]
     *
     * [クラス名[{0}]のパッケージ名が指定されていません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.ERR001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileErr001(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "クラス名[{0}]のパッケージ名が指定されていません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.ERR001");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.ERR002]
     *
     * [メッセージ定義ID[{0}]において、キー[{1}]が2回以上あらわれました。同じキーは2回以上指定することはできません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.ERR002]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileErr002(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "メッセージ定義ID[{0}]において、キー[{1}]が2回以上あらわれました。同じキーは2回以上指定することはできません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.ERR002");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.ERR003]
     *
     * [クラス名[{0}]のフィールド[{1}]の型名が指定されていません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.ERR003]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileErr003(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "クラス名[{0}]のフィールド[{1}]の型名が指定されていません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.ERR003");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.ERR004]
     *
     * [クラス名[{0}] でフィールド名が指定されていないものがあります。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.ERR004]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileErr004(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "クラス名[{0}] でフィールド名が指定されていないものがあります。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.ERR004");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.ERR005]
     *
     * [クラス名[{0}] フィールド[{1}]の「型」が指定されていません。「型」を指定してください。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.ERR005]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileErr005(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "クラス名[{0}] フィールド[{1}]の「型」が指定されていません。「型」を指定してください。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.ERR005");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.ERR006]
     *
     * [クラス名[{0}] フィールド[{1}]の「デフォルト値({2})」がセットされています。しかし「{3}」はデフォルト値をサポートしません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @param arg2 置換文字列{2}を置換する値。java.lang.String型を与えてください。
     * @param arg3 置換文字列{3}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.ERR006]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileErr006(final String arg0, final String arg1, final String arg2, final String arg3) {
        // 初期値として定義書の値を利用します。
        String strFormat = "クラス名[{0}] フィールド[{1}]の「デフォルト値({2})」がセットされています。しかし「{3}」はデフォルト値をサポートしません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.ERR006");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1, arg2, arg3}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.ERR007]
     *
     * [クラス名[{0}]の委譲フィールド[{1}]の型名が指定されていません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @param arg1 置換文字列{1}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.ERR007]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileErr007(final String arg0, final String arg1) {
        // 初期値として定義書の値を利用します。
        String strFormat = "クラス名[{0}]の委譲フィールド[{1}]の型名が指定されていません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.ERR007");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0, arg1}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.FIELD.NAME]
     *
     * [フィールド [{0}]] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.FIELD.NAME]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileFieldName(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド [{0}]";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.FIELD.NAME");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.FIELD.TYPE]
     *
     * [項目の型 [{0}]] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.FIELD.TYPE]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileFieldType(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "項目の型 [{0}]";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.FIELD.TYPE");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.FIELD.DEFAULT]
     *
     * [規定値   [{0}]] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.FIELD.DEFAULT]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileFieldDefault(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "規定値   [{0}]";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.FIELD.DEFAULT");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.SET.LANGDOC.01]
     *
     * [フィールド [{0}]のセッターメソッド] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.SET.LANGDOC.01]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileSetLangdoc01(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド [{0}]のセッターメソッド";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.SET.LANGDOC.01");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.SET.LANGDOC.02]
     *
     * [項目の型 [{0}]] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.SET.LANGDOC.02]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileSetLangdoc02(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "項目の型 [{0}]";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.SET.LANGDOC.02");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.SET.ARG.LANGDOC]
     *
     * [フィールド[{0}]に格納したい値] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.SET.ARG.LANGDOC]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileSetArgLangdoc(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド[{0}]に格納したい値";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.SET.ARG.LANGDOC");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.GET.LANGDOC.01]
     *
     * [フィールド[{0}]のゲッターメソッド] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.GET.LANGDOC.01]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileGetLangdoc01(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド[{0}]のゲッターメソッド";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.GET.LANGDOC.01");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.GET.LANGDOC.02]
     *
     * [項目の型 [{0}]] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.GET.LANGDOC.02]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileGetLangdoc02(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "項目の型 [{0}]";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.GET.LANGDOC.02");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.GET.ARG.LANGDOC]
     *
     * [規定値   [{0}]] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.GET.ARG.LANGDOC]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileGetArgLangdoc(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "規定値   [{0}]";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.GET.ARG.LANGDOC");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.GET.RETURN.LANGDOC]
     *
     * [フィールド[{0}]に格納されている値] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.GET.RETURN.LANGDOC]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileGetReturnLangdoc(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド[{0}]に格納されている値";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.GET.RETURN.LANGDOC");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.TYPE.LANGDOC.01]
     *
     * [フィールド[{0}]のタイプメソッド] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.TYPE.LANGDOC.01]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileTypeLangdoc01(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド[{0}]のタイプメソッド";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.TYPE.LANGDOC.01");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.TYPE.LANGDOC.02]
     *
     * [項目の型 [{0}]] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.TYPE.LANGDOC.02]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileTypeLangdoc02(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "項目の型 [{0}]";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.TYPE.LANGDOC.02");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.TYPE.ARG.LANGDOC]
     *
     * [規定値   [{0}]] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.TYPE.ARG.LANGDOC]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileTypeArgLangdoc(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "規定値   [{0}]";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.TYPE.ARG.LANGDOC");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[XML2SOURCE_FILE.TYPE.RETURN.LANGDOC]
     *
     * [フィールド[{0}]の型名文字列] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[XML2SOURCE_FILE.TYPE.RETURN.LANGDOC]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getXml2sourceFileTypeReturnLangdoc(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "フィールド[{0}]の型名文字列";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("XML2SOURCE_FILE.TYPE.RETURN.LANGDOC");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[ANTTASK.ERR001]
     *
     * [メタディレクトリ[{0}]が存在しません。] (ja)<br>
     *
     * @param arg0 置換文字列{0}を置換する値。java.lang.String型を与えてください。
     * @return key[ANTTASK.ERR001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getAnttaskErr001(final String arg0) {
        // 初期値として定義書の値を利用します。
        String strFormat = "メタディレクトリ[{0}]が存在しません。";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("ANTTASK.ERR001");
            }
        } catch (MissingResourceException ex) {
        }
        final MessageFormat messageFormat = new MessageFormat(strFormat);
        final StringBuffer strbuf = new StringBuffer();
        // 与えられた引数を元に置換文字列を置き換えます。
        messageFormat.format(new Object[] {arg0}, strbuf, null);
        return strbuf.toString();
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_COMMON_CS]
     *
     * [blancovalueobjectcs-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON_CS]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommonCs() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectcs-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON_CS");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_COMMON_JS]
     *
     * [blancovalueobjectjs-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON_JS]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommonJs() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectjs-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON_JS");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_COMMON_VB]
     *
     * [blancovalueobjectvb-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON_VB]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommonVb() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectvb-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON_VB");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_COMMON_PHP]
     *
     * [blancovalueobjectphp-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON_PHP]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommonPhp() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectphp-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON_PHP");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_COMMON_RUBY]
     *
     * [blancovalueobjectruby-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON_RUBY]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommonRuby() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectruby-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON_RUBY");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_COMMON_PYTHON]
     *
     * [blancovalueobjectpython-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON_PYTHON]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommonPython() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectpython-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON_PYTHON");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoTypeReferenceKt], key[META2XML.ELEMENT_COMMON_KT]
     *
     * [blancovalueobjectkt-common] (ja)<br>
     *
     * @return key[META2XML.ELEMENT_COMMON_KT]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlElementCommonKt() {
        // 初期値として定義書の値を利用します。
        String strFormat = "blancovalueobjectkt-common";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ELEMENT_COMMON_KT");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }
}

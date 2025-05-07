package blanco.typereferencekt.task;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import blanco.typereferencekt.task.valueobject.BlancoTypeReferenceKtProcessInput;

/**
 * Apache Antタスク [BlancoTypeReferenceKt]のクラス。
 *
 * バリューオブジェクト定義書などからソースコードを自動生成する BlancoTypeReferenceKtのAntTaskです。<br>
 * このクラスでは、Apache Antタスクで一般的に必要なチェックなどのコーディングを肩代わりします。
 * 実際の処理は パッケージ[blanco.typereferencekt.task]にBlancoTypeReferenceKtBatchProcessクラスを作成して記述してください。<br>
 * <br>
 * Antタスクへの組み込み例<br>
 * <pre>
 * &lt;taskdef name=&quot;blancotypereferencekt&quot; classname=&quot;blanco.typereferencekt.task.BlancoTypeReferenceKtTask">
 *     &lt;classpath&gt;
 *         &lt;fileset dir=&quot;lib&quot; includes=&quot;*.jar&quot; /&gt;
 *         &lt;fileset dir=&quot;lib.ant&quot; includes=&quot;*.jar&quot; /&gt;
 *     &lt;/classpath&gt;
 * &lt;/taskdef&gt;
 * </pre>
 */
public class BlancoTypeReferenceKtTask extends Task {
    /**
     * バリューオブジェクト定義書などからソースコードを自動生成する BlancoTypeReferenceKtのAntTaskです。
     */
    protected BlancoTypeReferenceKtProcessInput fInput = new BlancoTypeReferenceKtProcessInput();

    /**
     * フィールド [metadir] に値がセットされたかどうか。
     */
    protected boolean fIsFieldMetadirProcessed = false;

    /**
     * フィールド [targetdir] に値がセットされたかどうか。
     */
    protected boolean fIsFieldTargetdirProcessed = false;

    /**
     * フィールド [tmpdir] に値がセットされたかどうか。
     */
    protected boolean fIsFieldTmpdirProcessed = false;

    /**
     * フィールド [encoding] に値がセットされたかどうか。
     */
    protected boolean fIsFieldEncodingProcessed = false;

    /**
     * フィールド [xmlrootelement] に値がセットされたかどうか。
     */
    protected boolean fIsFieldXmlrootelementProcessed = false;

    /**
     * フィールド [sheetType] に値がセットされたかどうか。
     */
    protected boolean fIsFieldSheetTypeProcessed = false;

    /**
     * フィールド [targetStyle] に値がセットされたかどうか。
     */
    protected boolean fIsFieldTargetStyleProcessed = false;

    /**
     * フィールド [lineSeparator] に値がセットされたかどうか。
     */
    protected boolean fIsFieldLineSeparatorProcessed = false;

    /**
     * フィールド [packageName] に値がセットされたかどうか。
     */
    protected boolean fIsFieldPackageNameProcessed = false;

    /**
     * フィールド [className] に値がセットされたかどうか。
     */
    protected boolean fIsFieldClassNameProcessed = false;

    /**
     * フィールド [mapName] に値がセットされたかどうか。
     */
    protected boolean fIsFieldMapNameProcessed = false;

    /**
     * フィールド [mapKeyType] に値がセットされたかどうか。
     */
    protected boolean fIsFieldMapKeyTypeProcessed = false;

    /**
     * フィールド [valueObjectMetadirs] に値がセットされたかどうか。
     */
    protected boolean fIsFieldValueObjectMetadirsProcessed = false;

    /**
     * フィールド [restgeneratorMetadirs] に値がセットされたかどうか。
     */
    protected boolean fIsFieldRestgeneratorMetadirsProcessed = false;

    /**
     * verboseモードで動作させるかどうか。
     *
     * @param arg verboseモードで動作させるかどうか。
     */
    public void setVerbose(final boolean arg) {
        fInput.setVerbose(arg);
    }

    /**
     * verboseモードで動作させるかどうか。
     *
     * @return verboseモードで動作させるかどうか。
     */
    public boolean getVerbose() {
        return fInput.getVerbose();
    }

    /**
     * Antタスクの[metadir]アトリビュートのセッターメソッド。
     *
     * 項目番号: 1<br>
     * メタディレクトリ。xlsファイルの格納先または xmlファイルの格納先を指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setMetadir(final String arg) {
        fInput.setMetadir(arg);
        fIsFieldMetadirProcessed = true;
    }

    /**
     * Antタスクの[metadir]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 1<br>
     * メタディレクトリ。xlsファイルの格納先または xmlファイルの格納先を指定します。<br>
     * 必須アトリビュートです。Apache Antタスク上で必ず値が指定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getMetadir() {
        return fInput.getMetadir();
    }

    /**
     * Antタスクの[targetdir]アトリビュートのセッターメソッド。
     *
     * 項目番号: 2<br>
     * 出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。<br>
     *
     * @param arg セットしたい値
     */
    public void setTargetdir(final String arg) {
        fInput.setTargetdir(arg);
        fIsFieldTargetdirProcessed = true;
    }

    /**
     * Antタスクの[targetdir]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 2<br>
     * 出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。<br>
     * デフォルト値[blanco]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getTargetdir() {
        return fInput.getTargetdir();
    }

    /**
     * Antタスクの[tmpdir]アトリビュートのセッターメソッド。
     *
     * 項目番号: 3<br>
     * テンポラリディレクトリを指定します。無指定の場合にはカレント直下のtmpを用います。<br>
     *
     * @param arg セットしたい値
     */
    public void setTmpdir(final String arg) {
        fInput.setTmpdir(arg);
        fIsFieldTmpdirProcessed = true;
    }

    /**
     * Antタスクの[tmpdir]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 3<br>
     * テンポラリディレクトリを指定します。無指定の場合にはカレント直下のtmpを用います。<br>
     * デフォルト値[tmp]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getTmpdir() {
        return fInput.getTmpdir();
    }

    /**
     * Antタスクの[encoding]アトリビュートのセッターメソッド。
     *
     * 項目番号: 4<br>
     * 自動生成するソースファイルの文字エンコーディングを指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setEncoding(final String arg) {
        fInput.setEncoding(arg);
        fIsFieldEncodingProcessed = true;
    }

    /**
     * Antタスクの[encoding]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 4<br>
     * 自動生成するソースファイルの文字エンコーディングを指定します。<br>
     *
     * @return このフィールドの値
     */
    public String getEncoding() {
        return fInput.getEncoding();
    }

    /**
     * Antタスクの[xmlrootelement]アトリビュートのセッターメソッド。
     *
     * 項目番号: 5<br>
     * XML ルート要素のアノテーションを出力するかどうか。JDK 1.6 以降が必要。<br>
     *
     * @param arg セットしたい値
     */
    public void setXmlrootelement(final boolean arg) {
        fInput.setXmlrootelement(arg);
        fIsFieldXmlrootelementProcessed = true;
    }

    /**
     * Antタスクの[xmlrootelement]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 5<br>
     * XML ルート要素のアノテーションを出力するかどうか。JDK 1.6 以降が必要。<br>
     * デフォルト値[false]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public boolean getXmlrootelement() {
        return fInput.getXmlrootelement();
    }

    /**
     * Antタスクの[sheetType]アトリビュートのセッターメソッド。
     *
     * 項目番号: 6<br>
     * meta定義書が期待しているプログラミング言語を指定します<br>
     *
     * @param arg セットしたい値
     */
    public void setSheetType(final String arg) {
        fInput.setSheetType(arg);
        fIsFieldSheetTypeProcessed = true;
    }

    /**
     * Antタスクの[sheetType]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 6<br>
     * meta定義書が期待しているプログラミング言語を指定します<br>
     * デフォルト値[java]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getSheetType() {
        return fInput.getSheetType();
    }

    /**
     * Antタスクの[targetStyle]アトリビュートのセッターメソッド。
     *
     * 項目番号: 7<br>
     * 出力先フォルダの書式を指定します。&lt;br&gt;\nblanco: [targetdir]/main&lt;br&gt;\nmaven: [targetdir]/main/java&lt;br&gt;\nfree: [targetdir](targetdirが無指定の場合はblanco/main)<br>
     *
     * @param arg セットしたい値
     */
    public void setTargetStyle(final String arg) {
        fInput.setTargetStyle(arg);
        fIsFieldTargetStyleProcessed = true;
    }

    /**
     * Antタスクの[targetStyle]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 7<br>
     * 出力先フォルダの書式を指定します。&lt;br&gt;\nblanco: [targetdir]/main&lt;br&gt;\nmaven: [targetdir]/main/java&lt;br&gt;\nfree: [targetdir](targetdirが無指定の場合はblanco/main)<br>
     * デフォルト値[blanco]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getTargetStyle() {
        return fInput.getTargetStyle();
    }

    /**
     * Antタスクの[lineSeparator]アトリビュートのセッターメソッド。
     *
     * 項目番号: 8<br>
     * 行末記号をしていします。LF=0x0a, CR=0x0d, CFLF=0x0d0x0a とします。LFがデフォルトです。<br>
     *
     * @param arg セットしたい値
     */
    public void setLineSeparator(final String arg) {
        fInput.setLineSeparator(arg);
        fIsFieldLineSeparatorProcessed = true;
    }

    /**
     * Antタスクの[lineSeparator]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 8<br>
     * 行末記号をしていします。LF=0x0a, CR=0x0d, CFLF=0x0d0x0a とします。LFがデフォルトです。<br>
     * デフォルト値[LF]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getLineSeparator() {
        return fInput.getLineSeparator();
    }

    /**
     * Antタスクの[packageName]アトリビュートのセッターメソッド。
     *
     * 項目番号: 9<br>
     * 出力する TypeReference たちのパッケージ名を指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setPackageName(final String arg) {
        fInput.setPackageName(arg);
        fIsFieldPackageNameProcessed = true;
    }

    /**
     * Antタスクの[packageName]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 9<br>
     * 出力する TypeReference たちのパッケージ名を指定します。<br>
     * デフォルト値[blanco.typereference]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getPackageName() {
        return fInput.getPackageName();
    }

    /**
     * Antタスクの[className]アトリビュートのセッターメソッド。
     *
     * 項目番号: 10<br>
     * TypeReference 定義のクラス名を指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setClassName(final String arg) {
        fInput.setClassName(arg);
        fIsFieldClassNameProcessed = true;
    }

    /**
     * Antタスクの[className]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 10<br>
     * TypeReference 定義のクラス名を指定します。<br>
     * デフォルト値[BlancoTypeReference]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getClassName() {
        return fInput.getClassName();
    }

    /**
     * Antタスクの[mapName]アトリビュートのセッターメソッド。
     *
     * 項目番号: 11<br>
     * TypeReference 定義のクラス名を指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setMapName(final String arg) {
        fInput.setMapName(arg);
        fIsFieldMapNameProcessed = true;
    }

    /**
     * Antタスクの[mapName]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 11<br>
     * TypeReference 定義のクラス名を指定します。<br>
     * デフォルト値[BlancoTypeReferenceMap]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getMapName() {
        return fInput.getMapName();
    }

    /**
     * Antタスクの[mapKeyType]アトリビュートのセッターメソッド。
     *
     * 項目番号: 12<br>
     * string または class を指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setMapKeyType(final String arg) {
        fInput.setMapKeyType(arg);
        fIsFieldMapKeyTypeProcessed = true;
    }

    /**
     * Antタスクの[mapKeyType]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 12<br>
     * string または class を指定します。<br>
     * デフォルト値[class]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getMapKeyType() {
        return fInput.getMapKeyType();
    }

    /**
     * Antタスクの[valueObjectMetadirs]アトリビュートのセッターメソッド。
     *
     * 項目番号: 13<br>
     * valueObjectのmetaディレクトリを指定します。複数ある場合はカンマで区切ります。<br>
     *
     * @param arg セットしたい値
     */
    public void setValueObjectMetadirs(final String arg) {
        fInput.setValueObjectMetadirs(arg);
        fIsFieldValueObjectMetadirsProcessed = true;
    }

    /**
     * Antタスクの[valueObjectMetadirs]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 13<br>
     * valueObjectのmetaディレクトリを指定します。複数ある場合はカンマで区切ります。<br>
     *
     * @return このフィールドの値
     */
    public String getValueObjectMetadirs() {
        return fInput.getValueObjectMetadirs();
    }

    /**
     * Antタスクの[restgeneratorMetadirs]アトリビュートのセッターメソッド。
     *
     * 項目番号: 14<br>
     * restgeneratorのmetaディレクトリを指定します。複数ある場合はカンマで区切ります。<br>
     *
     * @param arg セットしたい値
     */
    public void setRestgeneratorMetadirs(final String arg) {
        fInput.setRestgeneratorMetadirs(arg);
        fIsFieldRestgeneratorMetadirsProcessed = true;
    }

    /**
     * Antタスクの[restgeneratorMetadirs]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 14<br>
     * restgeneratorのmetaディレクトリを指定します。複数ある場合はカンマで区切ります。<br>
     *
     * @return このフィールドの値
     */
    public String getRestgeneratorMetadirs() {
        return fInput.getRestgeneratorMetadirs();
    }

    /**
     * Antタスクのメイン処理。Apache Antから このメソッドが呼び出されます。
     *
     * @throws BuildException タスクとしての例外が発生した場合。
     */
    @Override
    public final void execute() throws BuildException {
        System.out.println("BlancoTypeReferenceKtTask begin.");

        // 項目番号[1], アトリビュート[metadir]は必須入力です。入力チェックを行います。
        if (fIsFieldMetadirProcessed == false) {
            throw new BuildException("必須アトリビュート[metadir]が設定されていません。処理を中断します。");
        }

        if (getVerbose()) {
            System.out.println("- verbose:[true]");
            System.out.println("- metadir:[" + getMetadir() + "]");
            System.out.println("- targetdir:[" + getTargetdir() + "]");
            System.out.println("- tmpdir:[" + getTmpdir() + "]");
            System.out.println("- encoding:[" + getEncoding() + "]");
            System.out.println("- xmlrootelement:[" + getXmlrootelement() + "]");
            System.out.println("- sheetType:[" + getSheetType() + "]");
            System.out.println("- targetStyle:[" + getTargetStyle() + "]");
            System.out.println("- lineSeparator:[" + getLineSeparator() + "]");
            System.out.println("- packageName:[" + getPackageName() + "]");
            System.out.println("- className:[" + getClassName() + "]");
            System.out.println("- mapName:[" + getMapName() + "]");
            System.out.println("- mapKeyType:[" + getMapKeyType() + "]");
            System.out.println("- valueObjectMetadirs:[" + getValueObjectMetadirs() + "]");
            System.out.println("- restgeneratorMetadirs:[" + getRestgeneratorMetadirs() + "]");
        }

        try {
            // 実際のAntタスクの主処理を実行します。
            // If you get a compile error at this point, You may be able to solve it by implementing a BlancoTypeReferenceKtProcess interface and creating an BlancoTypeReferenceKtProcessImpl class in package blanco.typereferencekt.task.
            final BlancoTypeReferenceKtProcess proc = new BlancoTypeReferenceKtProcessImpl();
            if (proc.execute(fInput) != BlancoTypeReferenceKtBatchProcess.END_SUCCESS) {
                throw new BuildException("The task has terminated abnormally.");
            }
        } catch (IllegalArgumentException e) {
            if (getVerbose()) {
                e.printStackTrace();
            }
            throw new BuildException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("タスクを処理中に例外が発生しました。処理を中断します。" + e.toString());
        } catch (Error e) {
            e.printStackTrace();
            throw new BuildException("タスクを処理中にエラーが発生しました。処理を中断します。" + e.toString());
        }
    }
}

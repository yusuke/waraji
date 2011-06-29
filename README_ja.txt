-------------------------侍 1.0-----------------------
"侍" とは:
侍 はスレッドダンプを解析するGUIツールです。

侍 はたった 150 行のコードでできていますので、とても信頼性が高く、理解がしやすく、またカスタマイズが容易です。

システム要件:
WebLogic Server 6.1, 7.0 or 8.1
OS: Java をサポートする Windows や Unix

セットアップ:
1)komuso.zip を適切なディレクトリに解凍する

2)komuso.properties を以下のように編集する
JAVA_HOME を C:\bea81sp2\jrockit81sp2_141_05 など Javaホームディレクトリに
WL_HOME を C:\bea81sp2\weblogic81\server など WebLogic ホームディレクトリに

3)komuso_ja.properties を以下のように編集する
java.naming.provider.url を WebLogic の URL に
java.naming.security.principal を WebLogic 管理者のユーザ名に
java.naming.security.credentials を WebLogic 管理者のパスワードに

典型的な設定では以下のようになります
java.naming.provider.url=t3://127.0.0.1:7001
java.naming.security.principal=system
java.naming.security.credentials=weblogic

加えて、サンプリング間隔、サンプル回数、任意の MBean 属性を指定することができます。
詳しくは komuso_ja.properties を見てください。

komuso.properties は実行時に上書きされます。これはラベルにマルチバイトを使えるようにするためで、komuso_ja.properties に対して native2ascii をかけているからです。
ラベルにマルチバイト文字を使う必要がなければ、komuso.properties, komuso.sh/cmd をご利用いただいても結構です。

使い方:
コマンドラインより komuso_ja.sh/bat を実行すると、CSV形式で WebLogic の状態を記録します。
出力先のファイル名を指定することもできます。
- Unix 環境(Solaris, Linux, HP-UX, MacOSX, AIX)
$ komuso_ja.sh [filename]
- Windows
> komuso_ja.bat [filename]

エラー対応:
-java.lang.IllegalArgumentException: mbean not found [heap free:name:type:property]
これは MBean が見つからなかったことを示します。name, type が正しいか確認してください。

-java.lang.IllegalArgumentException: property not found [heap free:name:type:property]
これは MBean は見つかったが、指定したプロパティが見つからなかったことを示します。
プロパティが存在するか確認してください。

-javax.naming.CommunicationException.  Root exception is java.net.ConnectException: t3://localhost:7001: Destination unreachable; nested exception is:
        java.net.ConnectException: Connection refused: connect; No available router to destination
これは侍と WLS 間の接続が失われたことを示します。
ネットワークと、WLS が落ちていないか確認してください。

コンパイル:
必要に応じて自由にカスタマイズすることができます。
compile.sh/bat でコンパイルできます。

コメント等ございましたらお気軽にどうぞ。
山本裕介
yusukey@bea.com
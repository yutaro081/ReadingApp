# ReadingApp

## 概要
読んだ本を管理するための読書管理Webアプリです。

未経験からJavaのWeb開発を学習する中で、
MVC・DAO・JDBC・CRUDの理解を深めることを目的に制作しました。

## 主な機能

- 本の一覧表示
- 本の登録
- 本の詳細表示
- 本の編集
- 本の削除

## 使用技術

- Java
- Servlet / JSP
- JDBC
- JSTL
- H2 Database
- Apache Tomcat 11
- Eclipse

## アプリの構成

- Model：Book→本のID、タイトル、著者、読書状況を保持します。
- View：JSP→一覧・登録・詳細・編集画面を担当します。
- Controller：Servlet→リクエストを受け取り、DAOの呼び出しや画面遷移を担当します。
- DAO：BookDAO→JDBCを利用してH2 DatabaseへのSELECT / INSERT / UPDATE / DELETEを担当します。

## 学習・工夫したこと

- MVCを意識してServletとJSPの役割を分けた
- DAOを使用してデータベース処理を分離した
- PreparedStatementを使用してSQLを実行した
- 本のIDを利用して詳細表示・編集・削除を実装した

## 開発中に発生した問題と解決
### JSTLが利用できない

TomcatだけではJSTLを利用できなかったため、
必要なJSTLライブラリを追加しました。

### H2へ接続できない

No suitable driver found が発生したため、
H2 JDBC Driverを追加し、
JavaからH2へ接続できるようにしました。

### フォームの値がnullになる

HTMLの name 属性と
Servletの getParameter() が一致していないことが原因でした。

フォームからServletへデータが渡る仕組みについて
理解を深めることができました。

## AIの活用

開発ではChatGPTを学習支援・デバッグ支援として利用しました。

完成コードをそのまま利用するのではなく、
処理を小さな単位に分けて、
コードの役割を確認しながら実装しました。

エラーが発生した際には、
原因を確認して修正する流れも学習しました。

## 今後追加したい機能
- 本の検索
- 読書メモ
- ログイン機能
- UI / CSSの改善
- AIを利用した読書支援
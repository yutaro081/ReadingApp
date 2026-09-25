# ReadingApp

## 概要
読んだ本を管理するための読書管理webアプリです。

JavaのServlet / JSP、JDBC、H2データベースを使用し、
MVCを意識して作成しています。

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
- Apatch Tomcat 11
- Eclipse

## アプリの構成

- Model：Book
- View：JSP
- Controller：Servlet
- Database Access：BookDAO

## 学習・工夫したこと

- MVCを意識してServletとJSPの役割を分けた
- DAOを使用してデータベース処理を分離した
- PreparedStatementを使用してSQLを実行した
- 本のIDを利用して詳細表示・編集・削除を実装した

## 今後追加したい機能

- 検索機能
- 読書メモ
- ログイン機能
- AIを利用した読書支援機能
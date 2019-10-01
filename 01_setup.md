# サーバサイドJava

## 1. インストール

### 1.0. リポジトリの更新
- sudo apt update

### 1.1. jdk(java開発環境)のインストール
- sudo apt install default-jdk

### 1.2. tomcat(ap&webサーバ)
- sudo apt install tomcat8

### 1.3. tomcat関連モジュール

#### 1.3.1. Documentation
- sudo apt install tomcat8-docs

#### 1.3.2. examples
- sudo apt install tomcat8-examples

#### 1.3.3. 管理画面
- sudo apt install tomcat8-admin

### 1.4 MariaDB(dbサーバ)

#### 1.4.1. インストール
- sudo apt install mariadb-server mariadb-client

#### 1.4.2. rootのパスワードなどセキュリティの設定
- sudo mysql_secure_installation

#### 1.4.3. sudoなしでrootでデータベースに接続するための設定

##### 1.4.3.1. 一旦、sudoで接続
- sudo mysql -u root -p

##### 1.4.3.2. 以下を実行
- use mysql;
- update user set plugin='mysql_native_password' where user='root';
- flush privileges; 
- quit;

##### 1.4.3.3. 以降は以下で接続可能
- mysql -u root -p

## 2. tomcatの操作

### 2.1. アプリケーション格納フォルダ
- /var/lib/tomcat8/webapps

### 2.2. URL
- 192.168.33.10:8080

### 2.3. サーバ

#### 2.3.1. 起動
S- sudo service tomcat8 start

#### 2.3.2. 終了
- sudo service tomcat8 stop

#### 2.3.3. 再起動
- sudo service tomcat8 restart

#### 2.3.4. ステータス確認
- sudo service tomcat8 status

## 3. 開発環境の設定

### 3.1. vagrantユーザをtomcat8グループに追加
- sudo adduser vagrant tomcat8
- ログインし直す

### 3.2. JAVA_HOME(不要？)

#### 3.2.1. 設定ファイルを開く
- sudo vi /etc/default/tomcat8

#### 3.2.2. 以下の記述を追加、tomcat再起動
- JAVA_HOME=/usr/lib/jvm/java-9-openjdk-amd64/bin/java

### 3.3. CATALINA_HOME、CATALINA_BASE、CLASSPATH

#### 3.3.1. 設定ファイルを開く
- sudo vi ~/.bashrc

#### 3.3.2. 以下の記述を追加
- export CATALINA_HOME=/usr/share/tomcat8
- export CATALINA_BASE=/var/lib/tomcat8
- export CLASSPATH=$CLASSPATH:$CATALINA_HOME/lib/servlet-api.jar:$CATALINA_HOME/lib/jsp-api.jar:$CATALINA_BASE/webapps/selfjsp/WEB-INF/classes/

#### 3.3.3. 設定ファイルの再読込
- . ~/.bashrc


## 3.4. ファイルリストを表示する設定

#### 3.4.1. 設定ファイルを開く
- sudo vi /var/lib/tomcat8/conf/web.xml

#### 3.4.2. 以下の変更
- <param-name>がlistingsの<param-value>をfalseからtrueに変える

#### 3.4.3. tomcat再起動
- sudo service tomcat8 restart

## 4. サンプルファイルについて

### 4.1. コピー先
- /var/lib/tomcat8/webapps

### 4.2. 動作確認用データの設定

#### 4.2.1. ディレクトリの移動
- cd /var/lib/tomcat8/webapps/selfjsp

#### 4.2.2. rootユーザでデータベースに接続
- mysql -u root -p

#### 4.2.3. database作成
- create database jsp;

#### 4.2.3. user作成
- grant all on jsp.* to jsp@localhost identified by 'jsp';

#### 4.2.4. 一旦切断
- exit

#### 4.2.5. 動作確認用データの設定
- mysql -u jsp -p jsp < selfjsp.sql

## 5. Jersey開発環境

### 5.1 mavenのインストール
- sudo apt install maven

### 5.2 proxyの設定
- sudo vi /etc/maven/settings.xml
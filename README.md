# java_kadai65_question

学校の課題で作ったJavaの質問をするプログラム

## 説明
　質問を表示して、それに対して、文字列か選択を答えるプログラムを製作した。質問に対する答えはいくつか存在できるよう、可変長とした。質問と答えはcsvファイルからデータを読み込む。

　問題一つ一つはquestionの名前が含まれるクラスで管理し、questionの集合としてcollectionを用意した。さらに、いくつかのcollectionを想定して、collectionをcollectionManagerで管理する仕様とした。そのほか、collectionをもとに問題を出すworkbookや、CSVファイルを読み込むcsvFileReaderのクラスを用意した。
　なお、これらの動作を実現するため、授業内容に加えて、interfaceとファイルの読み込みに関するクラスを使用した。

## 動作例
　参考に、動作例を以下に示す。

```

現在利用可能なコレクションの一覧
 0: 終了する
 1:          単位問題 問題数: 2
 2:         英単語問題 問題数: 4
コレクションの番号を入力> 2

現在のコレクション:英単語問題
 0: このワークブックを閉じる
 1: 出題順を初期化する
 2: 出題順をシャッフルする
 3: 問題を解く
 4: 問題の一覧を見る
実行する番号を入力> 4

英単語問題 問題数: 4
 1. 抽象の英単語は？
 2. 予算の英単語は？(b)
 3. 「～を発行する」の英単語は？
 4. 「…を案内する」の英単語は？

現在のコレクション:英単語問題
 0: このワークブックを閉じる
 1: 出題順を初期化する
 2: 出題順をシャッフルする
 3: 問題を解く
 4: 問題の一覧を見る
実行する番号を入力> 2

現在のコレクション:英単語問題
 0: このワークブックを閉じる
 1: 出題順を初期化する
 2: 出題順をシャッフルする
 3: 問題を解く
 4: 問題の一覧を見る
実行する番号を入力> 4

英単語問題 問題数: 4
 1. 「～を発行する」の英単語は？
 2. 抽象の英単語は？
 3. 「…を案内する」の英単語は？
 4. 予算の英単語は？(b)

現在のコレクション:英単語問題
 0: このワークブックを閉じる
 1: 出題順を初期化する
 2: 出題順をシャッフルする
 3: 問題を解く
 4: 問題の一覧を見る
実行する番号を入力> 3

番号  1/ 4  (現在の正解数  0)
問題:「～を発行する」の英単語は？
 1: publisher
 2: publish
 3: expand
選択肢の番号を入力> 2

正解

番号  2/ 4  (現在の正解数  1)
問題:抽象の英単語は？
回答の文字列を入力> abstract

正解

番号  3/ 4  (現在の正解数  2)
問題:「…を案内する」の英単語は？
 1: make a purchase
 2: encase
 3: show around
選択肢の番号を入力> 3

正解

番号  4/ 4  (現在の正解数  3)
問題:予算の英単語は？(b)
回答の文字列を入力> adsasdfasdf

不正解

終了です
正解数  3/ 4 正答率 75.00%
現在のコレクション:英単語問題
 0: このワークブックを閉じる
 1: 出題順を初期化する
 2: 出題順をシャッフルする
 3: 問題を解く
 4: 問題の一覧を見る
実行する番号を入力> 0


現在利用可能なコレクションの一覧
 0: 終了する
 1:          単位問題 問題数: 2
 2:         英単語問題 問題数: 4
コレクションの番号を入力> 0

終了します

```

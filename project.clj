(defproject ansicommonlisp-book-clojure "1.0.0-SNAPSHOT"
  :description "Exercises of the ANSI Common Lisp book (Paul Graham, Prentice Hall) in Clojure"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]]
  :dev-dependencies [[swank-clojure "1.2.0"]
                     [lein-run "1.0.1-SNAPSHOT"]]
  :aot [acl.ch05.ex9.PathFoundException])

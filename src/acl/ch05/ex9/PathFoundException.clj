;; to compile this
;; be sure to have ch05 and ch05/classes in your java path
;; Check with (System/getProperty "java.class.path")
;;
;; here is what I have in my .emacs for swank
;;
;; (setq swank-clojure-classpath (list "~/.swank-clojure/*"
;; "~/Documents/Projects/Clojure/ansicommonlisp-book-clojure/ch05/"
;; "~/Documents/Projects/Clojure/ansicommonlisp-book-clojure/ch05/classes"))
;;
;; then make (compile 'ex9.PathFoundException)
;; 

(ns ex9.PathFoundException
  (:import java.util.List)
  (:gen-class 
   :extends Exception
   :methods [ 
;            [setPath [java.util.List] void]
             [getPath [] java.util.List]
	     ]
   :init init
   :constructors {[java.util.List] []} ;; order matters!
   :state state
   ))

(defn -init [path]
  [[] (atom path)])

; (defn -setPath [this path]
;   (reset! (.state this) path))

(defn -getPath [this]
  @(.state this))

;; (compile 'ex9.PathFoundException)

;; (import 'ex9.PathFoundException)
;; (PathFoundException. [1 2 3])


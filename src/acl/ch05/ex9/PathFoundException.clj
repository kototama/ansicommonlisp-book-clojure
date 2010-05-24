(ns acl.ch05.ex9.PathFoundException
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

;; to compile:
;;(compile 'acl.ch05.ex9.PathFoundException)

;; some test
;; (import 'acl.ch05.ex9.PathFoundException)
;; (PathFoundException. [1 2 3])


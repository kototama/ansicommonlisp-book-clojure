;; keyword arguments are not part of Clojure but we can get
;; the similar feature with a map and destructive binding
;;
;; see http://stuartsierra.com/2010/01/15/keyword-arguments-in-clojure

;; for the implementation it does not make so much sense to use
;; a test function since we have regular expression in the JVM
;; and in Clojure!

(defn tokens
  ([s]
     (tokens s {:regex #"\S+" :start 0}))
  ([s & [{:keys [regex start]}]]
     (re-seq regex s)))
  
;; user> (tokens "ab12 3cde.f" )
;; ("ab12" "3cde.f")
;; user> (tokens "ab12 3cde.f" {:regex #"[a-zA-Z]+"})
;; ("ab" "cde" "f")

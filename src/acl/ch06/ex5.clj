;; directly taken from the Clojure code :-) !
;;
;; if your are using SLIME you can use 
;; M-x slime-edit-definition to see the definition
;; of a function
;;

(ns acl.ch06.ex5)

(defn our-remove
  [pred coll]
  (filter (complement pred) coll))


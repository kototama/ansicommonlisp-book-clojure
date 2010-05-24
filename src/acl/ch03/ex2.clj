(ns acl.ch03.ex2)

(defn stable-union [l1 l2]
  (distinct (concat l1 l2)))



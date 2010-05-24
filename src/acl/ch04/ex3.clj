(ns acl.ch04.ex3)

(defstruct node :ele :l :m :r)

(defn tree-contains? [t ele]
  (if (nil? t)
    false
    (if (= ele (:ele t))
      true
      (or (tree-contains? (:l t) ele)
          (tree-contains? (:m t) ele)
          (tree-contains? (:r t) ele)))))

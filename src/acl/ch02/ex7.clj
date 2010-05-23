(ns acl.ch02.ex7)

(defn contains-list? [l]
  (if (empty? l)
    false
    (or (list? (first l))
        (contains-list? (rest l)))))

(defn contains-seq? [col]
  (if (empty? col)
    false
    (or (seq? (first col))
        (recur (rest col)))))

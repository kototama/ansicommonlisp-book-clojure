(ns acl.ch04.ex5)

;; does not make so much sense since values
;; are immutable
(defn bst-adjoin [bst x comp]
  (if (bst-find bst x comp)
    bst
    (bst-insert bst x comp)))


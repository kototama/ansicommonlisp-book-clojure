;; multiple values are lisp specific

;; we can return the result as vector
(defn maxmin [col]
  [(apply max col) (apply min col)])

;; or as a map
(defn maxmin2 [col]
  {:max (apply max col) :min (apply min col)})


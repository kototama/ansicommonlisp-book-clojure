(load-file "bst.clj")

(defn bst-list [bst]
  (if (nil? bst)
    '()
    (let [lvalues (bst-accumulate (:l bst))
          rvalues (bst-accumulate (:r bst))]
      (conj (into lvalues rvalues) (:elt bst)))))

(defn bst-orderedlist [bst]
  (sort > (bst-list bst)))

(def nums (reduce (fn [acc x] (bst-insert acc x <)) nil [5 8 4 2 1 9 6 7 3]))

(comment 
  (= (bst-orderedlist nums) '(9 8 7 6 5 4 3 2 1))
)


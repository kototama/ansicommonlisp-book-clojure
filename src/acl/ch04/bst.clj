(ns acl.ch04.bst
 (:use clojure.contrib.def))

(declare percolate bst-remove-max bst-remove-min)

(defstruct node :elt :l :r)

(defn bst-insert [bst x comp]
  (if (nil? bst)
    (struct node x)
    (let [elt (:elt bst)]
      (if (= x elt)
        bst
        (if (comp x elt)
          (assoc bst :l (bst-insert (:l bst) x comp))
          (assoc bst :r (bst-insert (:r bst) x comp)))))))

;; with tail call
(defn bst-insert-tc [bst x comp]
  (loop [bst bst
         acc ()]
    (if (nil? bst)
      (loop [tree (struct node x)
             stack acc]
        (let [[lr elt branch] (first stack)]
          (if (empty? stack)
            tree
            (if (= lr :l)
              (recur (struct node elt branch tree) (rest stack))
              (recur (struct node elt tree branch) (rest stack))))))
      (let [elt (:elt bst)]
        (if (= x elt)
          bst
          (if (comp x elt)
            (recur (:l bst) (cons [:r elt (:r bst)] acc))
            (recur (:r bst) (cons [:l elt (:l bst)] acc))))))))

;; tail call without loop
(defn bst-insert-tc2 [bst x comp]
  (loop [bst bst
         acc ()]
    (if (nil? bst)
      (reduce (fn [tree [lr elt branch]]
                (if (= lr :l)
                  (struct node elt branch tree)
                  (struct node elt tree branch)))
              (struct node x)
              acc)
      (let [elt (:elt bst)]
        (if (= x elt)
          bst
          (if (comp x elt)
            (recur (:l bst) (cons [:r elt (:r bst)] acc))
            (recur (:r bst) (cons [:l elt (:l bst)] acc))))))))

;; tail call with function composition
;; see http://inclojurewetrust.blogspot.com/2009/11/tail-recursion-and-function-composition.html
;;
(defn bst-insert-tc3 [bst x cmp]
  (loop [bst bst
         f identity]
    (if (nil? bst)
      (f (struct node x))
      (let [elt (:elt bst)]
        (if (= x elt)
          bst
          (if (cmp x elt)
            (recur (:l bst) (comp f (fn [l] (struct node elt l (:r bst)))))
            (recur (:r bst) (comp f (fn [r] (struct node elt (:l bst) r))))))))))

(defn bst-find [bst x comp]
  (if (nil? bst)
    nil
    (let [elt (:elt bst)]
      (if (= x elt)
        bst
        (if (comp x elt)
          (recur (:l bst) x comp)
          (recur (:r bst) x comp))))))

(defn bst-min [bst]
  (and bst
       (or (bst-min (:l bst)) bst)))

(defn bst-max [bst]
  (and bst
       (or (bst-max (:r bst)) bst)))

(defn bst-remove [bst x comp]
  (if (nil? bst)
    nil
    (let [elt (:elt bst)]
      (if (= x elt)
        (percolate bst)
        (if (comp x elt)
          (assoc bst :l (bst-remove (:l bst) x comp))
          (assoc bst :r (bst-remove (:r bst) x comp)))))))

(defn bst-traverse [bst f]
  (when bst
    (bst-traverse (:l bst) f)
    (f (:elt bst))
    (bst-traverse (:r bst) f)))


(defn- percolate [bst]
  (let [l (:l bst)
        r (:r bst)]
    (cond (nil? l) r
          (nil? r) l
          :else
          (if (zero? (rand-int 2))
            (assoc bst :elt (bst-max bst) :l (bst-remove-max (:l bst)))
            (assoc bst :elt (bst-min bst) :r (bst-remove-min (:r bst)))))))

(defn- bst-remove-min [bst]
  (if (nil? (:l bst))
    (:r bst)
    (struct node 
            (:elt bst)
            (bst-remove-min (:l bst))
            (:r bst))))

(defn- bst-remove-max [bst]
  (if (nil? (:r bst))
    (:l bst)
    (struct node 
            (:elt bst)
            (:l bst)
            (bst-remove-max (:r bst)))))




(ns acl.ch06.ex4)

(defn most
  ([col]
     (most identity col))
  ([f col]
     (reduce (fn [acc x]
               (let [max1 (first acc)
                     max2 (second acc)
                     val (f x)]
                 (cond (nil? max1) [val nil]
                       (nil? max2) (if (> val max1) [val max1] [max1 val])
                       (> val max1) [val max1]
                       (> val max2) [max1 val]
                       :else [max1 max2]))) [nil nil] col)))

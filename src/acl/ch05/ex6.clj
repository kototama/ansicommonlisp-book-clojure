(defn myinterpose [sep col]
   (butlast (reduce (fn [acc x] (concat acc [x sep])) [] col)))

(defn myinterpose2 [sep col]
  (loop [[x nxt :as col] col
         res []]
    (if (nil? nxt)
      (concat res [x])
      (recur (rest col) (concat res [x sep])))))


(= (myinterpose2 \- "abcd") (myinterpose \- "abcd") (interpose \- "abcd"))





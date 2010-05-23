(defn precedes-helper [col x pre preds]
  (if (empty? col)
    preds
    (let [el (first col)]
      (if (= el x)
        (recur (rest col) x el (conj preds pre))
        (recur (rest col) x el preds)))))

(defn precedes [col x]
  (precedes-helper  (rest col) x (first col) #{}))

(precedes "abracadabra" \a) ;; #{\c \d \r}

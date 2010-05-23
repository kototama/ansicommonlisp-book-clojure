(defn printlazy []
  (let [l (take 10 (repeat 10))]
    (printf "%s" (list l))))

(printlazy)


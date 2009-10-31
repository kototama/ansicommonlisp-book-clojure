(use 'clojure.contrib.def)
(use 'clojure.contrib.import-static)

(import-static java.lang.Math ceil)

(declare finder round)


(defn bincontains? [coll key]
  (if (not (vector? coll))
    ;; in this case, better perform a linear search
    (throw (Exception. "Invalid collection type")))
  (let [len (count coll)]
    (and (not (zero? len))
         (finder coll key 0 (dec len)))))

;; Round in Lisp rounds to the nearest even digit.
;; In Java round is equivalent to (int)Math.floor(a + 0.5f)
;;
;; What we really need in the context of this algorithm
;; is a round that returns 0 when passed 0.5
;;
(defn- round [x]
  (int (ceil (- x 0.5))))

(defn- finder [vec x start end]
  ;; (printf "%s\n" (subvec vec start end))
  (let [rng (- end start)]
    (if (zero? rng)
      (if (= x (get vec start))
        true
        false)
      (let [mid (+ start (round (double (/ rng 2))))
            y (get vec mid)]
        ;; (printf "rng = %s mid = %s s = %s e = %s y = %s\n\n", rng mid start end y)
        (if (< x y)
          (recur vec x start (dec mid))
          (if (> x y)
            (recur vec x (inc mid) end)
            true))))))
  
(comment

  (bincontains? [1 2 3 4 5 6] 9) ;; false
  (bincontains? [0 1 2 3 4 5 6 7 8 9] 6) ;; true

)
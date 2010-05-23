(use '[clojure.contrib.str-utils :only (re-split)])

(defn parse-date [s]
  (let [cal (zipmap ["jan" "fev" "mar" "apr" "may" "jun" "jul" 
                     "aug" "sep" "oct" "nov" "dec"] (iterate inc 1))
        [day month year] (re-split #"\s+" s)
        d (Integer/parseInt day)
        m (cal (.toLowerCase month))
        y (Integer/parseInt year)]
    [d m y]))

(comment

  (parse-date "16 Aug 1980") ;; [16 8 1980]

)


(ns acl.ch07.ex4)


;; old school things... but it shows the use of letfn!
(defn print-array [floats]
  (letfn [(print-line
           [ncol]
           (doseq [_ (range ncol)]
             (print "*----------"))
           (print "*"))]
   (let [ncol (count (first floats))]
     (print-line ncol)
     (println)
     (doseq [col floats]
       (print "|")
       (doseq [x col]
         (printf "%10.2f|" x))
       (println))
     (print-line ncol))))

 ;; (print-array [[1.1 1.2 1.3]
 ;;                     [2.1 2.2 2.3]
 ;;                     [3.1 3.2 3.3]
 ;;                     [4.1 4.2 4.3]])
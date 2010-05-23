(use 'clojure.contrib.def)
(use 'clojure.contrib.import-static)

(import-static java.lang.Math abs)


(declare dfs new-paths)

(defn member [x sq]
  (if (empty? sq)
    false
    (if (= x (first sq))
      true
      (recur x (rest sq)))))


(defn longest-path [start end net]
  (let [tovisit (rest (net :start))]
    (dfs end (list start) '() tovisit 0 net)))

(defn- dfs [end path allpaths tovisit depth net]
  "Depth-first search with tail recursion. Return all possible paths that go to element end"
  (if (= end (first path))
    (if (empty? tovisit)
      allpaths
      (let [diffdepth (inc (abs (- depth (second tovisit))))
	    nextpath (cons (first tovisit) (drop diffdepth path))]
	(recur end nextpath (conj allpaths path) (drop 2 tovisit) (second tovisit) net)))
    ;; else
    (let [node (first path)
	  children (net node)
	  child (first children)
	  sibling (rest children)]
      (printf "node = %s\n" node)
      (printf "path = %s\n" path)
      (printf "children = %s\n" children)
      (printf "(first tovisit) = %s\n" (first tovisit))

      (if (empty? children)
	(if (empty? tovisit)
	  allpaths
	  ;; explore the other children
	  (if (member (first tovisit) path)
	    ;; already explored
	    (do
	      (printf "CONTAINS\n")
	      (let [nexttovisit (drop 2 tovisit)
		    diffdepth (inc (abs (- depth (second nexttovisit))))
		    nextpath (cons (first nexttovisit) (drop diffdepth path))]
		(recur end nextpath allpaths nexttovisit (inc depth) net)))
	    (let [diffdepth (inc (abs (- depth (second tovisit))))
		  nextpath (cons (first tovisit) (drop diffdepth path))
		  nexttovisit (drop 2 tovisit)]
	      (recur end nextpath allpaths nexttovisit (inc depth) net))))
	;; explore the first child if not explored
	;; else repeat the process on the other
	(if (member child path)
	  (do
	    (printf "> CONTAINS\n")
	    (let [child (second children)
		  nexttovisit (interleave (drop 2 children) (repeat depth))]
	      (recur end (cons child path) allpaths (concat nexttovisit tovisit) (inc depth) net)))
	  (let [nexttovisit (interleave sibling (repeat depth))]
	    (do (printf "path = %s does not contains child %s\n", path child)
	      (recur end (cons child path) allpaths (concat nexttovisit tovisit) (inc depth) net))))))))

;;(comment 
 
  (def minnet { 'a '(b c), 'b '(c), 'c '(d)})

 (longest-path 'a 'd minnet) ;; (A B C D)
 (longest-path 'a 'e {'a '(b f), 'b '(c), 'c '(d), 'd '(b e), 'f '(e), 'e '()}) ;; (A B C D E)
;;(longest-path 'd 'f '((a b f) (b c) (c d) (d b e) (f e))) ;; nil
;;(longest-path 'x 'y nil) ;; nil

;;  )		     


(ns hamming)

(defn distance [dna1 dna2]
  (loop [d1 dna1
         d2 dna2
         counts 0]
    (cond
      (and (empty? d1) (empty? d2)) counts
      (or (empty? d1) (empty? d2)) nil
      (= (first d1) (first d2)) (recur (rest d1) (rest d2) counts)
      :else (recur (rest d1) (rest d2) (inc counts)))))

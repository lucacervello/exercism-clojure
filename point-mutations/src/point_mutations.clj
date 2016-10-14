(ns point-mutations)
;Thanks to EricGebhart :D Really nice code
(defn hamming-distance [dna1 dna2]
  (if (= (count dna1) (count dna2))
    (count (filter false? (map = dna1 dna2)))))

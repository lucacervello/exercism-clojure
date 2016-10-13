(ns rna-transcription)

(defn to-rna [dna-sequence]
  (apply str (map #(case %
                     \G "C"
                     \C "G"
                     \T "A"
                     \A "U"
                     (throw (AssertionError. "Not a valid character"))) dna-sequence)))

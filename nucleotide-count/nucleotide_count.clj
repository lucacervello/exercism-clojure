(ns nucleotide-count)

(def valid-nucleotide-map {\A 0 \G 0 \T 0 \C 0})

(defn valid-string? [string]
  (not (re-find #"[^AGTC]" string)))

(defn nucleotide-counts [str]
  (if (valid-string? str)
    (merge valid-nucleotide-map (frequencies str))
    (throw (Exception. "invalid nucleotide"))))

(defn count [symb string]
  (dec (get (nucleotide-counts (str string symb)) symb 0)))

(ns beer-song)

(defn verse [number]
  (sing number number))

(defn sing
  ([max] (sing max 0))
  ([max min]
   (clojure.string/replace-first
    (apply str
           (for [i (reverse (range min (inc max)))]
             (case i
               0 "\nNo more bottles of beer on the wall, no more bottles of beer.
Go to the store and buy some more, 99 bottles of beer on the wall.\n"
               1 "\n1 bottle of beer on the wall, 1 bottle of beer.
Take it down and pass it around, no more bottles of beer on the wall.\n"
               2 "\n2 bottles of beer on the wall, 2 bottles of beer.
Take one down and pass it around, 1 bottle of beer on the wall.\n"
               (str "\n" i " bottles of beer on the wall, " i " bottles of beer.\n"
                    "Take one down and pass it around, " (dec i) " bottles of beer on the wall.\n"))))
    "\n" "")))

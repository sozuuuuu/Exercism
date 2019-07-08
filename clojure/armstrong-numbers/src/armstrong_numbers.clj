(ns armstrong-numbers)

(require '[clojure.string :as str])

(defn exp [x n] (reduce * (repeat n x)))

(defn determine-digits [num]
  (loop [num num
         digits []]
         (if (= num 0) digits
         (recur (quot num 10) (conj digits (rem num 10))))))

(defn armstrong? [num]
  (let [digits (determine-digits num)
        len (count digits)
        exp-each (map (fn [n] (exp n len)) digits)
        n (reduce + exp-each)]
    (= n num)))

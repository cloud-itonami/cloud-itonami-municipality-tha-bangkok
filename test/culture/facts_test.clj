(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest bangkok-has-culture-basis
  (let [sb (facts/spec-basis "bangkok")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "bangkok" (:culture/municipality %)) sb))
    (is (every? #(= "THA" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "chiang-mai")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["bangkok" "chiang-mai"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["chiang-mai"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "bangkok" :dish))))
  (is (= ["bangkok.beverage.mekhong"]
         (mapv :culture/id (facts/by-kind "bangkok" :beverage))))
  (is (empty? (facts/by-kind "bangkok" :product)))
  (is (empty? (facts/by-kind "chiang-mai" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))

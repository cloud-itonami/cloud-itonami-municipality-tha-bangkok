(ns culture.facts
  "Regional-culture catalog for Bangkok -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked onto this
  municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"bangkok"
   [{:culture/id "bangkok.dish.pad-thai"
     :culture/name "Pad thai"
     :culture/name-local "ผัดไทย"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :dish
     :culture/summary "Stir-fried rice-noodle dish created in the 1930s-1940s during nation-building efforts, since become one of Thailand's national dishes rather than a Bangkok-specific one."
     :culture/url "https://en.wikipedia.org/wiki/Pad_thai"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bangkok.dish.boat-noodles"
     :culture/name "Boat noodles"
     :culture/name-local "ก๋วยเตี๋ยวเรือ"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :dish
     :culture/summary "Noodle dish with dark soy sauce, pickled bean curd and pig blood, originally served from boats that traversed Bangkok's canals; the Victory Monument neighborhood is a notable serving area."
     :culture/url "https://en.wikipedia.org/wiki/Boat_noodles"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bangkok.dish.khao-chae"
     :culture/name "Khao chae"
     :culture/name-local "ข้าวแช่"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :dish
     :culture/summary "Rice soaked in cool water, a Mon dish adapted into royal Thai cuisine during King Rama II's reign, found in Bangkok neighborhoods such as Banglampoo."
     :culture/url "https://en.wikipedia.org/wiki/Khao_chae"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bangkok.dish.tom-yum"
     :culture/name "Tom yum"
     :culture/name-local "ต้มยำ"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :dish
     :culture/summary "Family of hot and sour Thai soups originating in Central Thailand, the region that includes Bangkok."
     :culture/url "https://en.wikipedia.org/wiki/Tom_yum"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bangkok.beverage.mekhong"
     :culture/name "Mekhong"
     :culture/name-local "แม่โขง"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :beverage
     :culture/summary "Thailand's first domestically produced branded golden spirit, distilled, blended and bottled at the Bangyikhan Distillery on the outskirts of Bangkok."
     :culture/url "https://en.wikipedia.org/wiki/Mekhong_(spirit)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bangkok.craft.benjarong"
     :culture/name "Benjarong"
     :culture/name-local "เบญจรงค์"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :craft
     :culture/summary "Painted Thai ceramics with overglazed enamel colors, a Thai (not Bangkok-specific) craft tradition maintained by artisan communities for generations."
     :culture/url "https://en.wikipedia.org/wiki/Benjarong"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bangkok.festival.royal-ploughing-ceremony"
     :culture/name "Royal Ploughing Ceremony"
     :culture/name-local "พระราชพิธีพืชมงคล"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :festival
     :culture/summary "Ancient royal rite marking the start of the rice-growing season, whose Hindu portion is held at Sanam Luang in Bangkok following the Buddhist portion at the Grand Palace."
     :culture/url "https://en.wikipedia.org/wiki/Royal_Ploughing_Ceremony"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bangkok.heritage.grand-palace"
     :culture/name "Grand Palace"
     :culture/name-local "พระบรมมหาราชวัง"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :heritage
     :culture/summary "Palace complex in Bangkok begun in 1782 under King Rama I, official residence of the Kings of Siam and later Thailand."
     :culture/url "https://en.wikipedia.org/wiki/Grand_Palace"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "bangkok.heritage.wat-pho"
     :culture/name "Wat Pho"
     :culture/name-local "วัดโพธิ์"
     :culture/municipality "bangkok"
     :culture/country "THA"
     :culture/kind :heritage
     :culture/summary "Buddhist temple complex in Bangkok's Phra Nakhon District, home to a 46 m reclining Buddha and birthplace of traditional Thai massage."
     :culture/url "https://en.wikipedia.org/wiki/Wat_Pho"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-tha-bangkok culture catalog "
                 "(ADR-2607171400): " (count (get catalog "bangkok"))
                 " Bangkok entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))

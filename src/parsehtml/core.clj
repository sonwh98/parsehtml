(ns parsehtml.core)
(import 'org.jsoup.Jsoup)

(def ^org.jsoup.Connection httpConnection (Jsoup/connect "http://www.allmenus.com/ny/new-york/322071-xo-cafe-and-grill/menu/"))
(def ^org.jsoup.nodes.Document document (.get httpConnection))
(def ^org.jsoup.nodes.Element navDivTag (.getElementById document "menu"))

(def ^org.jsoup.select.Elements nameElements (.getElementsByClass navDivTag "name"))
(def ^org.jsoup.select.Elements priceElements (.getElementsByClass navDivTag "price"))

(def menu [])
(doseq [element nameElements]
  (def menu (conj menu (.html element))))

(def price [])
(doseq [element priceElements]
  (def price (conj price (.html element))))

(def myMap (zipmap menu price))

(myMap "Mango Pudding")


(def namePrice (map list menu price))
(prn namePrice)


(def menuMap {})
(def menuList [])

(doseq [menuElement menu]
  (def menuMap (:name menuElement))
  (def menuList (conj menuList menuMap)))

(def priceMap {})
(def priceList [])

(doseq [priceElement price]
  (def priceMap (:price priceElement))
  (def priceList (conj priceList priceMap)))

(doseq [priceElement price]
  (prn priceElement))




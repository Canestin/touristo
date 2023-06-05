import axios from "axios";
import { FLICKR_API_BASE_URL } from "../config";

const getPlacePhotos = async (latitude, longitude) => {
  const apiUrl = `${FLICKR_API_BASE_URL}&lat=${latitude}&lon=${longitude}`;
  console.log("API URL", apiUrl);

  try {
    const response = await axios.get(apiUrl);
    const photos = response.data.photos.photo;

    const image = photos.map(
      (photo) =>
        `https://live.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg`
    )[1];

    return image;
  } catch (error) {
    console.error("Error recovering photos :", error);
    return null;
  }
};

const departments = {
  "01": { department: "Ain", capital: "Bourg-en-Bresse" },
  "02": { department: "Aisne", capital: "Laon" },
  "03": { department: "Allier", capital: "Moulins" },
  "04": { department: "Alpes-de-Haute-Provence", capital: "Digne-les-Bains" },
  "05": { department: "Hautes-Alpes", capital: "Gap" },
  "06": { department: "Alpes-Maritimes", capital: "Nice" },
  "07": { department: "Ardèche", capital: "Privas" },
  "08": { department: "Ardennes", capital: "Charleville-Mézières" },
  "09": { department: "Ariège", capital: "Foix" },
  10: { department: "Aube", capital: "Troyes" },
  11: { department: "Aude", capital: "Carcassonne" },
  12: { department: "Aveyron", capital: "Rodez" },
  13: { department: "Bouches-du-Rhône", capital: "Marseille" },
  14: { department: "Calvados", capital: "Caen" },
  15: { department: "Cantal", capital: "Aurillac" },
  16: { department: "Charente", capital: "Angoulême" },
  17: { department: "Charente-Maritime", capital: "La Rochelle" },
  18: { department: "Cher", capital: "Bourges" },
  19: { department: "Corrèze", capital: "Tulle" },
  "2A": { department: "Corse-du-Sud", capital: "Ajaccio" },
  "2B": { department: "Haute-Corse", capital: "Bastia" },
  21: { department: "Côte-d'Or", capital: "Dijon" },
  22: { department: "Côtes-d'Armor", capital: "Saint-Brieuc" },
  23: { department: "Creuse", capital: "Guéret" },
  24: { department: "Dordogne", capital: "Périgueux" },
  25: { department: "Doubs", capital: "Besançon" },
  26: { department: "Drôme", capital: "Valence" },
  27: { department: "Eure", capital: "Évreux" },
  28: { department: "Eure-et-Loir", capital: "Chartres" },
  29: { department: "Finistère", capital: "Quimper" },
  30: { department: "Gard", capital: "Nîmes" },
  31: { department: "Haute-Garonne", capital: "Toulouse" },
  32: { department: "Gers", capital: "Auch" },
  33: { department: "Gironde", capital: "Bordeaux" },
  34: { department: "Hérault", capital: "Montpellier" },
  35: { department: "Ille-et-Vilaine", capital: "Rennes" },
  36: { department: "Indre", capital: "Châteauroux" },
  37: { department: "Indre-et-Loire", capital: "Tours" },
  38: { department: "Isère", capital: "Grenoble" },
  39: { department: "Jura", capital: "Lons-le-Saunier" },
  40: { department: "Landes", capital: "Mont-de-Marsan" },
  41: { department: "Loir-et-Cher", capital: "Blois" },
  42: { department: "Loire", capital: "Saint-Étienne" },
  43: { department: "Haute-Loire", capital: "Le Puy-en-Velay" },
  44: { department: "Loire-Atlantique", capital: "Nantes" },
  45: { department: "Loiret", capital: "Orléans" },
  46: { department: "Lot", capital: "Cahors" },
  47: { department: "Lot-et-Garonne", capital: "Agen" },
  48: { department: "Lozère", capital: "Mende" },
  49: { department: "Maine-et-Loire", capital: "Angers" },
  50: { department: "Manche", capital: "Saint-Lô" },
  51: { department: "Marne", capital: "Châlons-en-Champagne" },
  52: { department: "Haute-Marne", capital: "Chaumont" },
  53: { department: "Mayenne", capital: "Laval" },
  54: { department: "Meurthe-et-Moselle", capital: "Nancy" },
  55: { department: "Meuse", capital: "Bar-le-Duc" },
  56: { department: "Morbihan", capital: "Vannes" },
  57: { department: "Moselle", capital: "Metz" },
  58: { department: "Nièvre", capital: "Nevers" },
  59: { department: "Nord", capital: "Lille" },
  60: { department: "Oise", capital: "Beauvais" },
  61: { department: "Orne", capital: "Alençon" },
  62: { department: "Pas-de-Calais", capital: "Arras" },
  63: { department: "Puy-de-Dôme", capital: "Clermont-Ferrand" },
  64: { department: "Pyrénées-Atlantiques", capital: "Pau" },
  65: { department: "Hautes-Pyrénées", capital: "Tarbes" },
  66: { department: "Pyrénées-Orientales", capital: "Perpignan" },
  67: { department: "Bas-Rhin", capital: "Strasbourg" },
  68: { department: "Haut-Rhin", capital: "Colmar" },
  69: { department: "Rhône", capital: "Lyon" },
  70: { department: "Haute-Saône", capital: "Vesoul" },
  71: { department: "Saône-et-Loire", capital: "Mâcon" },
  72: { department: "Sarthe", capital: "Le Mans" },
  73: { department: "Savoie", capital: "Chambéry" },
  74: { department: "Haute-Savoie", capital: "Annecy" },
  75: { department: "Paris", capital: "Paris" },
  76: { department: "Seine-Maritime", capital: "Rouen" },
  77: { department: "Seine-et-Marne", capital: "Melun" },
  78: { department: "Yvelines", capital: "Versailles" },
  79: { department: "Deux-Sèvres", capital: "Niort" },
  80: { department: "Somme", capital: "Amiens" },
  81: { department: "Tarn", capital: "Albi" },
  82: { department: "Tarn-et-Garonne", capital: "Montauban" },
  83: { department: "Var", capital: "Toulon" },
  84: { department: "Vaucluse", capital: "Avignon" },
  85: { department: "Vendée", capital: "La Roche-sur-Yon" },
  86: { department: "Vienne", capital: "Poitiers" },
  87: { department: "Haute-Vienne", capital: "Limoges" },
  88: { department: "Vosges", capital: "Épinal" },
  89: { department: "Yonne", capital: "Auxerre" },
  90: { department: "Territoire de Belfort", capital: "Belfort" },
  91: { department: "Essonne", capital: "Évry" },
  92: { department: "Hauts-de-Seine", capital: "Nanterre" },
  93: { department: "Seine-Saint-Denis", capital: "Bobigny" },
  94: { department: "Val-de-Marne", capital: "Créteil" },
  95: { department: "Val-d'Oise", capital: "Cergy-Pontoise" },
  971: { department: "Guadeloupe", capital: "Basse-Terre" },
  972: { department: "Martinique", capital: "Fort-de-France" },
  973: { department: "Guyane", capital: "Cayenne" },
  974: { department: "La Réunion", capital: "Saint-Denis" },
  976: { department: "Mayotte", capital: "Mamoudzou" },
};

const historicalContexts = [
  "Ancient Roman era",
  "Medieval period",
  "Renaissance",
  "French Revolution",
  "Napoleonic era",
  "Belle Époque",
  "World War I",
  "Interwar period",
  "World War II",
  "Post-war reconstruction",
  "Cold War era",
  "Decolonization",
  "European integration",
  "Modern globalization",
  "Contemporary digital age",
  "Cultural Renaissance",
  "Industrial Revolution",
  "Art Nouveau movement",
  "Impressionist movement",
  "Surrealist movement",
];

export { getPlacePhotos, departments, historicalContexts };

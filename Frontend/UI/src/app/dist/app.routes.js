"use strict";
exports.__esModule = true;
exports.routes = void 0;
var card_component_1 = require("../card/card.component");
exports.routes = [
    { path: '', redirectTo: 'page/1', pathMatch: 'full' },
    { path: 'page/:pageNumber', component: card_component_1.CardComponent },
];

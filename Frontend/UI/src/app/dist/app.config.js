"use strict";
exports.__esModule = true;
exports.appConfig = void 0;
var router_1 = require("@angular/router");
var app_routes_1 = require("./app.routes");
var platform_browser_1 = require("@angular/platform-browser");
var animations_1 = require("@angular/platform-browser/animations");
exports.appConfig = {
    providers: [router_1.provideRouter(app_routes_1.routes), platform_browser_1.provideClientHydration(), animations_1.provideAnimations()]
};

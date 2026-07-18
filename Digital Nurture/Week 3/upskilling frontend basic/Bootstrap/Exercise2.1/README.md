# Exercise 2.1 - Bootstrap Directory Structure

## Overview
This document explains the Bootstrap 5 directory structure when installed via npm or downloaded manually.

---

## Directory Structure

After running `npm install bootstrap`, the following structure is created:

```
node_modules/
└── bootstrap/
    ├── dist/
    │   ├── css/
    │   │   ├── bootstrap.css
    │   │   ├── bootstrap.css.map
    │   │   ├── bootstrap.min.css
    │   │   ├── bootstrap.min.css.map
    │   │   ├── bootstrap-grid.css
    │   │   ├── bootstrap-grid.min.css
    │   │   ├── bootstrap-reboot.css
    │   │   └── bootstrap-reboot.min.css
    │   ├── js/
    │   │   ├── bootstrap.js
    │   │   ├── bootstrap.js.map
    │   │   ├── bootstrap.min.js
    │   │   ├── bootstrap.min.js.map
    │   │   ├── bootstrap.bundle.js
    │   │   └── bootstrap.bundle.min.js
    │   └── fonts/
    │       ├── bootstrap-icons.woff
    │       └── bootstrap-icons.woff2
    ├── js/
    │   └── src/
    │       ├── index.js
    │       ├── alert.js
    │       ├── button.js
    │       ├── carousel.js
    │       ├── collapse.js
    │       ├── dropdown.js
    │       ├── modal.js
    │       ├── offcanvas.js
    │       ├── popover.js
    │       ├── scrollspy.js
    │       ├── tab.js
    │       ├── toast.js
    │       └── tooltip.js
    ├── scss/
    │   ├── _variables.scss
    │   ├── _mixins.scss
    │   ├── _root.scss
    │   ├── _reboot.scss
    │   ├── _type.scss
    │   ├── _images.scss
    │   ├── _grid.scss
    │   ├── _functions.scss
    │   └── ... (many more partials)
    └── package.json
```

---

## Folder Descriptions

| Folder/File | Purpose | Description |
|---|---|---|
| `dist/css/` | Compiled CSS | Ready-to-use CSS files. `bootstrap.min.css` is the minified production version. `bootstrap-grid.css` provides only the grid system. `bootstrap-reboot.css` provides CSS resets. |
| `dist/js/` | Compiled JavaScript | Ready-to-use JS files. `bootstrap.bundle.min.js` includes Popper.js (needed for tooltips, popovers, dropdowns). `bootstrap.min.js` excludes Popper.js. |
| `dist/fonts/` | Icon Fonts | Contains Bootstrap Icons font files (woff and woff2 formats). Referenced by `bootstrap-icons.css`. |
| `js/src/` | JS Source Files | Individual JavaScript module source files for each Bootstrap plugin (alert, button, carousel, collapse, dropdown, modal, offcanvas, popover, scrollspy, tab, toast, tooltip). |
| `scss/` | Sass Source Files | SCSS source files for customizing Bootstrap. `_variables.scss` is the main file for changing colors, fonts, spacing, and breakpoints. |
| `package.json` | Package Config | npm package metadata including version, dependencies, and build scripts. |

---

## CSS Files Breakdown

| File | Size | Use Case |
|---|---|---|
| `bootstrap.min.css` | ~230KB | Full Bootstrap CSS — use for most projects |
| `bootstrap.grid.min.css` | ~20KB | Grid system only — use if you only need layout |
| `bootstrap.reboot.min.css` | ~5KB | CSS resets only — use as a starting point |
| `bootstrap.utilities.min.css` | ~100KB | Utility classes only — use with custom CSS |

## JS Files Breakdown

| File | Use Case |
|---|---|
| `bootstrap.bundle.min.js` | Includes Popper.js — **recommended for most projects** |
| `bootstrap.min.js` | Excludes Popper.js — use if you already include Popper.js separately |

---

## Key Takeaways

1. **For quick start:** Use CDN links (simplest approach)
2. **For npm projects:** Install via `npm install bootstrap` and reference `node_modules/bootstrap/dist/` files
3. **For customization:** Edit SCSS files in `scss/` folder, especially `_variables.scss`
4. **For production:** Always use `.min.css` and `.min.js` files
5. **For tooltips/popovers:** Use `bootstrap.bundle.min.js` (includes Popper.js)

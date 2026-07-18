# Exercise 19.2 - Sass Customization with _variables.scss

## Overview

Bootstrap 5 is built with Sass and highly customizable through SCSS variables. This document explains how to customize Bootstrap's primary colors and border radius using `_variables.scss`.

---

## Step 1: Setup

To customize Bootstrap with Sass, install Bootstrap via npm and set up a Sass compiler:

```bash
npm init -y
npm install bootstrap
npm install -D sass
```

Create your own SCSS file (e.g., `styles.scss`) that imports Bootstrap and overrides variables:

```scss
// Import Bootstrap functions first
@import "node_modules/bootstrap/scss/functions";

// Override variables BEFORE importing Bootstrap
@import "node_modules/bootstrap/scss/variables";
@import "node_modules/bootstrap/scss/variables-dark";

// Import the rest of Bootstrap
@import "node_modules/bootstrap/scss/mixins";
@import "node_modules/bootstrap/scss/root";
@import "node_modules/bootstrap/scss/reboot";
@import "node_modules/bootstrap/scss/type";
@import "node_modules/bootstrap/scss/containers";
@import "node_modules/bootstrap/scss/grid";
@import "node_modules/bootstrap/scss/buttons";
@import "node_modules/bootstrap/scss/card";
// ... import other modules as needed
```

Or use a simpler approach:

```scss
// Override default variable values
$primary: #6f42c1;    // Custom purple
$danger: #e83e8c;     // Custom pink
$success: #20c997;    // Custom teal
$border-radius: 0.5rem;
$border-radius-lg: 0.75rem;
$border-radius-sm: 0.25rem;

// Import all of Bootstrap
@import "node_modules/bootstrap/scss/bootstrap";
```

---

## Step 2: Customizing Primary Colors

### Default Bootstrap Colors

In `node_modules/bootstrap/scss/_variables.scss`, Bootstrap defines:

```scss
$blue:    #0d6efd;
$indigo:  #6610f2;
$purple:  #6f42c1;
$pink:    #d63384;
$red:     #dc3545;
$orange:  #fd7e14;
$yellow:  #ffc107;
$green:   #198754;
$teal:    #20c997;
$cyan:    #0dcaf0;

$primary:   $blue;
$secondary: $gray-600;
$success:   $green;
$info:      $cyan;
$warning:   $yellow;
$danger:    $red;
$light:     $gray-100;
$dark:      $gray-900;
```

### Customizing the Primary Color

To change the primary color, override it **before** importing Bootstrap:

```scss
// My custom theme
$primary: #6f42c1;    // Purple
$secondary: #6c757d;
$success: #28a745;
$info: #17a2b8;
$warning: #ffc107;
$danger: #dc3545;

@import "node_modules/bootstrap/scss/bootstrap";
```

This will automatically update:
- `.btn-primary` background and hover states
- `.bg-primary` background color
- `.text-primary` text color
- `.border-primary` border color
- `.link-primary` link color
- Navbar backgrounds using `bg-primary`
- Any component using the primary color

---

## Step 3: Customizing Border Radius

### Default Border Radius Variables

```scss
$border-radius:     0.375rem;   // 6px - Default
$border-radius-sm:  0.25rem;    // 4px - Small
$border-radius-lg:  0.5rem;     // 8px - Large
$border-radius-xl:  1rem;       // 16px - Extra large
$border-radius-pill: 50rem;     // Pill shape
```

### Customizing Border Radius

```scss
// Rounded modern design
$border-radius:     12px;
$border-radius-sm:  8px;
$border-radius-lg:  16px;
$border-radius-xl:  24px;

// Or sharp, minimal design
$border-radius:     0;
$border-radius-sm:  0;
$border-radius-lg:  0;
```

---

## Step 4: Complete Custom Theme Example

```scss
// ==========================================
// Custom Bootstrap Theme
// ==========================================

// --- Color Palette ---
$primary: #4f46e5;       // Indigo
$secondary: #64748b;     // Slate
$success: #10b981;       // Emerald
$warning: #f59e0b;       // Amber
$danger: #ef4444;        // Red
$info: #06b6d4;          // Cyan

// --- Body & Text ---
$body-bg: #f8fafc;
$body-color: #1e293b;

// --- Border Radius ---
$border-radius: 0.5rem;
$border-radius-sm: 0.25rem;
$border-radius-lg: 0.75rem;

// --- Fonts ---
$font-family-sans-serif: "Inter", system-ui, sans-serif;
$font-size-base: 1rem;

// --- Shadows ---
$box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
$box-shadow-lg: 0 10px 15px rgba(0, 0, 0, 0.1);

// --- Import Bootstrap ---
@import "node_modules/bootstrap/scss/bootstrap";
```

---

## Step 5: Adding to package.json scripts

```json
{
  "scripts": {
    "build:css": "sass scss/styles.scss css/styles.css --style=compressed",
    "watch:css": "sass --watch scss/styles.scss css/styles.css"
  }
}
```

Run with:

```bash
npm run build:css
npm run watch:css
```

---

## Key Takeaways

1. **Always override variables BEFORE importing Bootstrap** — Sass processes variables top-to-bottom
2. **Only import what you need** — Reduces file size
3. **Use `$primary` variable** — It cascades to all components that use it
4. **Border radius changes affect all components** — Cards, buttons, inputs, modals, etc.
5. **Use the `!default` flag** — Bootstrap variables use `!default`, so your overrides take precedence
6. **Compile for production** — Use `--style=compressed` for minified output

---

## Variable Categories

| Category | Examples | File |
|---|---|---|
| Colors | `$primary`, `$success`, `$danger` | `_variables.scss` |
| Spacing | `$spacer`, `$spacer-0` through `$spacer-5` | `_variables.scss` |
| Typography | `$font-family-base`, `$font-size-base`, `$h1-font-size` | `_variables.scss` |
| Border Radius | `$border-radius`, `$border-radius-sm/lg/xl/pill` | `_variables.scss` |
| Shadows | `$box-shadow`, `$box-shadow-sm`, `$box-shadow-lg` | `_variables.scss` |
| Breakpoints | `$grid-breakpoints`, `$container-max-widths` | `_variables.scss` |
| Z-index | `$zindex-dropdown`, `$zindex-modal`, `$zindex-tooltip` | `_variables.scss` |
| Transitions | `$transition-base`, `$transition-fade` | `_variables.scss` |

# EJP Interactive Reentry Guide Portal — Frontend

This is the Next.js 13 (App Router) frontend for the Education Justice Project. It provides:

- **Public**  
  - Searchable guide library  
  - Guide detail pages with dynamic SEO tags  
  - Interactive Leaflet map of guide locations  
- **Auth**  
  - Login via NextAuth (credentials → JWT)  
  - Role-based route protection (Admin vs. User)  
- **Admin**  
  - CRUD interface for guide metadata  
- **Performance & SEO**  
  - Server-side rendering for all pages  
  - JSON-LD and dynamic `<head>` for social sharing  

---

## Getting Started

### Prerequisites

- Node.js ≥ 16  
- npm ≥ 8  
- Running backend services on:
  - `http://localhost:8001/userservice`
  - `http://localhost:8002/resources`
  - `http://localhost:8003/orderservice`

### Installation

```bash
cd frontend
npm install


frontend/
├── app/
│   ├── layout.tsx         # Root layout (nav, footer)
│   ├── page.tsx           # Redirects to /library
│   ├── globals.css        # Global styles & Tailwind imports
│   ├── login/page.tsx     # Login form
│   ├── library/page.tsx   # Guide list & search
│   ├── library/[slug]/    # Guide detail
│   │   └── page.tsx
│   ├── map/page.tsx       # Interactive map view
│   └── admin/
│       ├── layout.tsx     # Admin layout & protection
│       └── guides/page.tsx# Guide CRUD interface
├── lib/                   # API client wrappers (axios + auth)
├── hooks/                 # React Query & auth hooks
├── public/                # Static assets (favicon, pdfs, etc.)
├── styles/                # Tailwind & global CSS
├── .env.local             # Env variables (gitignored)
├── next.config.ts         # Next.js config
├── package.json           # Dependencies & scripts
└── tsconfig.json          # TypeScript config

# Education Justice Project Interactive Reentry Guide Portal

## Overview
The Education Justice Project (EJP) is replacing its static PDF “Reentry Guides” with a dynamic, SEO-first portal. Visitors will enjoy full-text search, filter facets and an interactive map, while EJP staff use a secure admin interface to manage guides in real time—no code changes or redeploys needed.

---

## Context & Goal
On [educationjustice.net](https://educationjustice.net/) the **Reentry Guides** section is a simple dropdown of static PDFs:
- Mapping Your Future: 2025 Edition
- Mapping Your Future: National Edition
- A New Path: A Guide to the Challenges and Opportunities After Deportation

We will transform each guide into a dedicated, server-rendered page (e.g. `/library/mapping-your-future-2025`) with rich meta tags and structured data, combined with full-text search and an interactive map to make resources instantly accessible to users and easily discoverable by search engines.

---

## Project Vision & Goals
- **Empower Users** with intuitive search, filtering and map-based discovery
- **Optimize for Discovery** through server-side rendering, dynamic meta tags, JSON-LD and an auto-generated sitemap
- **Streamline Management** via a role-based admin UI for real-time guide CRUD operations
- **Modern Architecture** using independent Java/Spring Boot microservices and an SSR frontend (Nuxt 3 or Next.js)

---

## Quick Start
1. Clone the repository and navigate into it.
2. Build and start each microservice (user-service on port 8001, resource-service on 8002, order-service on 8003).
3. Launch the frontend application (default port 3000).

---

## Database Setup
**MySQL**  
Create a database named `parcel_xyz`.  
**Docker**  
Run a MySQL container named `ejp-mysql` with root password `root` and database `parcel_xyz`, exposing port 3306.

---

## Detailed Plan
1. **Backend Modules**
    - Scaffold `user-service`, `resource-service` and `order-service`; define entities, repositories, services and controllers; configure Swagger.
2. **Full-Text Search**
    - Add a documented search vector and database index; implement `/resources/search?q=` endpoint.
3. **Authentication & Security**
    - Integrate Spring Security + JWT; protect admin endpoints by role.
4. **SSR Frontend Setup**
    - Initialize Nuxt 3 or Next.js; add sitemap, robots.txt, dynamic `<head>`, and authentication modules.
5. **Library & Detail Pages**
    - Build `/library` (server-rendered list with client filtering) and `/library/[slug]` (SSR detail pages with dynamic titles, meta descriptions and JSON-LD).
6. **Map Integration**
    - Integrate Leaflet.js to render guide locations as interactive markers with download links.
7. **Admin Interface**
    - Secure `/admin` routes; implement CRUD forms for guide metadata and file uploads.
8. **SEO & Deployment**
    - Generate `sitemap.xml` and `robots.txt`; perform SEO, performance and accessibility audits; deploy backend and frontend.

---

## Architecture & UML Diagrams

### Component Diagram
```mermaid
flowchart LR
  subgraph Frontend
    FE[SSR App (Nuxt 3 / Next.js)]
  end
  subgraph Backend
    API[API Gateway]
    US[user-service]
    RS[resource-service]
    OS[order-service]
    DB[(Database)]
  end
  FE --> API
  API --> US
  API --> RS
  API --> OS
  US --> DB
  RS --> DB
  OS --> DB

## Sequence Diagram: Guide Search Flow
sequenceDiagram
  participant U as User Browser
  participant FE as Frontend SSR
  participant API as API Gateway
  participant RS as resource-service
  participant DB as Database

  U->>FE: Request `/library?q=housing`
  FE->>API: Forward search query
  API->>RS: Invoke `/resources/search?q=housing`
  RS->>DB: Perform full-text query
  DB-->>RS: Return matching guides
  RS-->>API: Return JSON results
  API-->>FE: Return JSON results
  FE-->>U: Render HTML with results and metadata


Module Details
user-service/
Manages user registration, JWT login, profile retrieval, full-text search and role-based status toggling.

resource-service/
Handles guide metadata CRUD, slug lookup and full-text search indexing and queries.

order-service/ (optional)
Demonstrates order placement, status updates and agent assignments.

frontend/
SSR application featuring:

/library — searchable guide list

/library/[slug] — SEO-optimized guide detail pages

/map — interactive guide map

/admin — role-protected CRUD interface
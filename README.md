# Education Justice Project Interactive Reentry Guide Portal

## Overview
The Education Justice Project (EJP) is creating a modern portal to replace static PDF “Reentry Guides” with a dynamic, searchable, map-driven experience. Users can easily find resources by keyword, state or topic, download guides directly, and explore a geographic view of available services. EJP staff gain a secure admin interface to add or update guides in real time—no redeploys required.

## Project Vision & Goals
- Empower returning citizens, families and service providers with intuitive search and filtering  
- Maximize organic reach through server-side rendering, dynamic meta tags, structured data and an auto-generated sitemap  
- Streamline guide management via a role-based admin UI, removing the need for code changes or manual deployments  
- Demonstrate a modular microservices architecture paired with a cutting-edge SSR frontend  

## Quick Start
1. **Clone & Navigate**  
   – Repository: https://github.com/Bharath-Ganesh/ejp_seo_optimization  
2. **Build & Run Services**  
   – **user-service** (port 8001)  
   – **resource-service** (port 8002)  
   – **order-service** (port 8003, optional)  
3. **Launch Frontend**  
   – **frontend** application (default port 3000)  

## Database Setup
- **MySQL**  
  • Create a database named `parcel_xyz`  
- **Docker**  
  • Run a MySQL container with:  
    – root password = `root`  
    – database = `parcel_xyz`  
    – port mapping 3306 → 3306  

## Module Details
- **user-service/**  
  Manages user registration, JWT-based login, profile retrieval, full-text search, and status toggling.  
- **resource-service/**  
  Handles Reentry Guide metadata: create/read/update/delete operations, slug lookup, full-text search indexing and queries.  
- **order-service/** (optional)  
  Illustrates order placement and status workflows for delivery agents.  
- **frontend/**  
  SSR application featuring:  
  - `/library` — searchable guide list  
  - `/library/[slug]` — SEO-optimized guide detail pages  
  - `/map` — interactive Leaflet map of guide locations  
  - `/admin` — secure CRUD interface for EJP staff  

## API Documentation
- **user-service**  
  • Swagger UI: http://localhost:8001/userservice/swagger-ui.html  
  • OpenAPI JSON: http://localhost:8001/userservice/v2/api-docs  
- **resource-service**  
  • Swagger UI: http://localhost:8002/resources/swagger-ui.html  
  • OpenAPI JSON: http://localhost:8002/resources/v2/api-docs  
- **order-service**  
  • Swagger UI: http://localhost:8003/orders/swagger-ui.html  
  • OpenAPI JSON: http://localhost:8003/orders/v2/api-docs  

## Next Steps
- Define and implement the resource-service data model with full-text indexing  
- Integrate JWT-based security across all services and protect admin frontend routes  
- Complete SSR frontend pages, wire up API calls, enable dynamic meta tags and sitemap generation  
- Deploy to staging, run SEO and accessibility audits, then promote to production  

## Contributing
1. Fork the repository  
2. Create a feature branch (`feature/your-feature`)  
3. Commit your changes with clear messages  
4. Open a Pull Request for review  

## License
This project is licensed under the MIT License. See the LICENSE file for details.  

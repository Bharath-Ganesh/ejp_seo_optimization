export const metadata = {
  title: 'EJP Reentry Guides',
  description: 'Search and explore reentry guides for returning citizens.',
}

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en">
      <body>
        <header>{/* global nav here */}</header>
        {children}
        <footer>{/* global footer here */}</footer>
      </body>
    </html>
  )
}

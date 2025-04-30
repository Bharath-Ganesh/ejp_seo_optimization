import { getServerSession } from 'next-auth'
import { authOptions } from '../api/auth/[...nextauth]'

export default async function AdminLayout({ children }: { children: React.ReactNode }) {
  const session = await getServerSession(authOptions)
  if (!session?.user?.roles?.includes('ADMIN')) {
    return <p>Access denied</p>
  }

  return (
    <html>
      <body>
        <nav>{/* admin nav */}</nav>
        {children}
      </body>
    </html>
  )
}

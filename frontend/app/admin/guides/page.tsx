'use client'
import { useState } from 'react'
import { resourceApi } from '@/lib/api'   // TS and Next.js both understand `@/` now

export default function AdminGuidesPage() {
  const [title, setTitle] = useState('')

  const handleCreate = async () => {
    await resourceApi('/admin/guides', { method: 'POST', data: { title } })
    // refetch or notify
  }

  return (
    <div>
      <h1>Manage Guides</h1>
      <input value={title} onChange={e => setTitle(e.target.value)} placeholder="New guide title" />
      <button onClick={handleCreate}>Create Guide</button>
    </div>
  )
}

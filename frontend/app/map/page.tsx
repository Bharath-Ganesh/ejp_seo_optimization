'use client'
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'
import 'leaflet/dist/leaflet.css'
import useSWR from 'swr'

const fetcher = (url: string) => fetch(url).then(res => res.json())

export default function MapPage() {
  const { data: guides } = useSWR('/api/guides', fetcher)

  return (
    <MapContainer center={[38, -97]} zoom={4} style={{ height: '100vh' }}>
      <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />
      {guides?.map((g: any) => g.latitude && (
        <Marker key={g.id} position={[g.latitude, g.longitude]}>
          <Popup>
            <a href={`/library/${g.slug}`}>{g.title}</a>
          </Popup>
        </Marker>
      ))}
    </MapContainer>
  )
}

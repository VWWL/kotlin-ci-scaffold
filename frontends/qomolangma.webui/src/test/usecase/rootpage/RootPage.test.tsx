import {screen} from '@testing-library/react';
import Root from "../../../pages/root"
import {ENRender} from "../../ENRender";
import {ZHRender} from "../../ZHRender";

test('should render RootPage in English', () => {
  ENRender.render(new Root(null).render())
  const linkElement = screen.getByText(/learn react/i)
  expect(linkElement).toBeInTheDocument()
  const linkElement2 = screen.getByText(/Qomolangma frontend app./i)
  expect(linkElement2).toBeInTheDocument()
})

test('should render RootPage in Chinese', () => {
  ZHRender.render(new Root(null).render())
  const linkElement = screen.getByText(/学习 react/i)
  expect(linkElement).toBeInTheDocument()
  const linkElement2 = screen.getByText(/Qomolangma 前端应用。/i)
  expect(linkElement2).toBeInTheDocument()
})
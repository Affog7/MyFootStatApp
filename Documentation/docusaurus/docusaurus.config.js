// @ts-check
// Note: type annotations allow type checking and IDEs autocompletion

const lightCodeTheme = require('prism-react-renderer/themes/github');
const darkCodeTheme = require('prism-react-renderer/themes/dracula');

/** @type {import('@docusaurus/types').Config} */
const math = require('remark-math');
const katex = require('rehype-katex');


const config = {
  title: 'My Documentation',
  tagline: 'My tagline',
  url: 'https://codefirst.iut.uca.fr',
  baseUrl: '/documentation/augustin.affognon/docusaurus/MyFoot/',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  favicon: 'img/favicon.ico',
  trailingSlash: true,

  // GitHub pages deployment config.
  // If you aren't using GitHub pages, you don't need these.
  organizationName: 'augustin.affognon', // Usually your GitHub org/user name.
  projectName: 'MyFoot', // Usually your repo name.

  // Even if you don't use internalization, you can use this field to set useful
  // metadata like html lang. For example, if your site is Chinese, you may want
  // to replace "en" with "zh-Hans".
  i18n: {
    defaultLocale: 'en',
    locales: ['en', 'fr'],
    localeConfigs: {
      en:{
        htmlLang: 'en-GB',
      }
    }
  },

  presets: [
    [
      'classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          // Please change this to your repo.
          // Remove this to remove the "edit this page" links.
          // editUrl:
          //   'https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/',
          remarkPlugins: [math],
          rehypePlugins: [katex],
        },
        blog: {
          showReadingTime: true,
          // Please change this to your repo.
          // Remove this to remove the "edit this page" links.
          // editUrl:
          //   'https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/',
          blogSidebarTitle: 'All posts',
          blogSidebarCount: 'ALL',
        },
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      }),
    ],
  ],
  stylesheets: [
    {
      href: 'https://cdn.jsdelivr.net/npm/katex@0.13.24/dist/katex.min.css',
      type: 'text/css',
      integrity:
        'sha384-odtC+0UGzzFL/6PNoE8rX/SPcQDXBJ+uRepguP4QkPCm2LBxH3FA3y+fKSiJ+AmM',
      crossorigin: 'anonymous',
    },
  ],
  themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
    ({
      navbar: {
        title: '',
        logo: {
          alt: 'CodeFirst',
          src: 'img/logo.svg',
          srcDark: 'img/LOGO_CODE1ERT_BLANC_VERT.svg'
        },
        items: [
          {
            type: 'doc',
            docId: 'intro',
            position: 'left',
            label: 'Documentation',
          },
          // {to: '/blog', label: 'Blog', position: 'left'},
          // {to: '/classesPage', label: 'Courses', position: 'left'},
          {
            type: 'localeDropdown',
            position: 'right',
          },
          // {
          //   href: 'https://codefirst.iut.uca.fr/',
          //   label: 'Start',
          //   position: 'right',
          // },
          
        ],
      },
      footer: {
        style: 'dark',
         links: [
          {
            title: 'Docs',
            items: [
              {
                label: 'Documentation',
                to: '/docs/intro',
              },
            ],
          },
          {
            title: 'More',
            items: [
              // {
              //   label: 'Blog',
              //   to: '/blog',
              // },
              {
                label: 'Code#0',
                href: 'https://codefirst.iut.uca.fr/',
              },
            ],
          },
        //   {
        //     title: 'Community',
        //     items: [
        //       {
        //         label: 'LinkedIn',
        //         href: 'https://www.linkedin.com/company/code-1st/',
        //       },
        //     ],
        //   },
       
         ],
        copyright: `Copyright © new Date().getFullYear() Code#0.`,
      },
      prism: {
        additionalLanguages: ['csharp', 'python', 'java'],
        theme: lightCodeTheme,
        darkTheme: darkCodeTheme,
        magicComments: [
          // Remember to extend the default highlight class name as well!
          {
            className: 'theme-code-block-highlighted-line',
            line: 'highlight-next-line',
            block: {start: 'highlight-start', end: 'highlight-end'},
          },
          {
            className: 'myOneAndOnlyHightlightedCodeBlock',
            line: 'my-highlight-next-line',
            block: {start: 'my-highlight-start', end: 'my-highlight-end'},
          },
        ],
      },
    }),
    markdown: {
      mermaid: true,
    },
    themes: ['@docusaurus/theme-mermaid'],
};

module.exports = config;
